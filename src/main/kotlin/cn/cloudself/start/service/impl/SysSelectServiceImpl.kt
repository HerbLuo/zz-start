package cn.cloudself.start.service.impl

import cn.cloudself.query.QueryProSql
import cn.cloudself.start.dao.*
import cn.cloudself.start.entity.*
import cn.cloudself.start.exception.http.PlanNotFindException
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.*
import cn.cloudself.start.service.ISysSelectService
import cn.cloudself.start.util.WebUtil
import cn.cloudself.start.util.copyTo
import cn.cloudself.start.util.i18n
import org.springframework.stereotype.Service

@Service
class SysSelectServiceImpl: ISysSelectService {
    override fun get(tag: String): SysSpRes {
        val sysSelect = SysSpQueryPro.selectBy().tag.equalsTo(tag).runLimit1()
            ?: throw PlanNotFindException("找不到tag: {}对应的查询方案配置", tag)
        val sysQueryElements = SysSpEleQueryPro.selectBy().sysSpId.equalsTo(sysSelect.id!!).run()
        return SysSpRes(sysSelect, sysQueryElements)
    }

    override fun getPlan(pageTag: String): SysSpUsrPlanRes {
        val tag = getTag(pageTag)

        val userId = WebUtil.getUserIdNonNull()
        val spId = SysSpQueryPro.selectBy().tag.equalsTo(tag).columnLimiter().id().firstOrNull()
            ?: throw PlanNotFindException("找不到tag: {}对应的查询方案配置", tag)

        val spEleList = SysSpEleQueryPro.selectBy().sysSpId.equalsTo(spId).run()

        val userPlanList: List<SysSpUsrPlanEntity> = SysSpUsrPlanQueryPro
            .selectBy().pageTag.equalsTo(pageTag)
            .and().parLeft().sysUserId.equalsTo(userId).or().public.equalsTo(true).parRight()
            .run()

        val userPlanIdList: List<Long> = userPlanList.map { it.id!! }
        val userPlanItems: List<SysSpUsrPlanItemEntity> = SysSpUsrPlanItemQueryPro
            .selectBy().sysSpUsrPlanId(userPlanIdList)
            .run()

        val userPlans = userPlanList.map {
            SysSpUsrPlan(it, userPlanItems.filter { item -> item.sysSpUsrPlanId == it.id })
        }.ifEmpty {
            val defPlan = SysSpUsrPlanEntity(id = -1, name = i18n("默认方案").toString(), default = true)
            listOf(SysSpUsrPlan(defPlan, listOf()))
        }

        val tblCols = SysSpUsrTblColQueryPro
            .selectBy().pageTag.equalsTo(pageTag)
            .and().sysUserId.equalsTo(userId)
            .run()
            .ifEmpty {
                spEleList.map {
                    val col = it.copyTo(SysSpUsrTblColEntity::class.java, "id")
                    col.title = it.aliasCn
                    col.dataIndex = it.alias
                    col
                }
            }

        return SysSpUsrPlanRes(pageTag, userPlans, spEleList, tblCols)
    }

    override fun getData(selectReq: SysSpDataReq): Async<SysSpDataRes> {
        val pageTag = selectReq.pageTag
        val tag = getTag(pageTag)
        val sysSelect = SysSpQueryPro.selectBy().tag.equalsTo(tag).runLimit1()
            ?: throw RequestBadException(i18n("找不到tag: {}对应的查询方案配置", tag))
        val sysSelectId = sysSelect.id!!

        val sqlBuilder = StringBuilder(sysSelect.sqlColumn)
        val paramsList = mutableListOf<Any?>()
        sqlBuilder.append('\n')
        // 添加条件
        val conditions = selectReq.conditions
        val aliasList: List<String> = conditions.map { it.alias }
        val selectElements: List<SysSpEleEntity> = SysSpEleQueryPro
            .selectBy().alias(aliasList)
            .and().sysSpId.equalsTo(sysSelectId)
            .run()

        fun parseConditions(conditions: List<SysSpDataReqCondition>) {
            var first = true
            for (condition in conditions) {
                if (!first) {
                    sqlBuilder.append(" and ")
                }
                first = false
                val operator = condition.operator
                if (operator == "or") {
                    sqlBuilder.append(" or ")
                    continue
                }
                if (operator == "()") {
                    parseConditions(condition.conditions ?: throw RequestBadException(i18n("()操作符必须传conditions字段")))
                    continue
                }
                val selectElement = selectElements.find { it.alias == condition.alias }
                val operatorsStrDb = selectElement?.limitConditions ?: throw ServerException(i18n("[BUG] sys_search_config_column数据库配置错误 {}"))
                val operatorsDb = operatorsStrDb.split(",")
                if (operatorsDb.indexOf(operator) < 0) {
                    throw RequestBadException(i18n("查询方案中不存在对应的操作符{}, 无法查询", operator))
                }
                sqlBuilder.append(selectElement.alias)
                sqlBuilder.append(" ", operator, " ?")
                paramsList.add(condition.value)
            }
        }
        if (conditions.isNotEmpty()) {
            sqlBuilder.append(" and (")
        }
        parseConditions(conditions)
        if (conditions.isNotEmpty()) {
            sqlBuilder.append(")")
        }
        val sqlForCount = sqlBuilder.toString()
        // 查询语句
        // 添加order by
        val orderBys = selectReq.orderBys
        if (orderBys.isNotEmpty()) {
            sqlBuilder.append(" order by ")
            for (orderBy in orderBys) {
                val ascDesc = if (orderBy.asc) " asc" else " desc"
                val column = selectElements.find { it.alias == orderBy.alias }?.sqlColumn
                    ?: throw RequestBadException(i18n("查询方案{}中不存在alias为{}的element", tag, orderBy.alias))
                sqlBuilder.append(column, ascDesc, ", ")
            }
            sqlBuilder.delete(sqlBuilder.length - 2, sqlBuilder.length)
        }
        // 添加分页信息
        val page = selectReq.page
        val pageSize = selectReq.pageSize
        val first = if (pageSize == -1) 0 else (page - 1) * pageSize
        if (pageSize != -1) {
            sqlBuilder.append(" limit ", first, ", ", pageSize + 1)
        }
        val params = paramsList.toTypedArray()
        val withNextPageRows = QueryProSql.create(sqlBuilder.toString(), params).query()
        val hasNext = withNextPageRows.size > pageSize
        val rows = if (hasNext) {
            withNextPageRows.dropLast(1)
        } else {
            withNextPageRows
        }

        return Async.create {
            val totalCountPromise: Async.Promise<Int> = if (hasNext) it.create {
                val sqlForCountWithConditions = "SELECT COUNT(*) FROM ($sqlForCount) t"
                val count = QueryProSql.create(sqlForCountWithConditions, params).queryOne(Int::class.java)
                    ?: throw ServerException(i18n("无法完成count查询, {}", sqlForCountWithConditions))
                count
            } else it.just(first + rows.size)

            SysSpDataRes(hasNext, totalCountPromise, rows)
        }
    }

    private fun getTag(pageTag: String): String {
        val splitterIndex = pageTag.indexOf(':')
        if (splitterIndex < 0) {
            throw RequestBadException("pageTag命名不符合要求, 示例：'<tag>:<page>'")
        }
        return pageTag.substring(0, splitterIndex)
    }
}