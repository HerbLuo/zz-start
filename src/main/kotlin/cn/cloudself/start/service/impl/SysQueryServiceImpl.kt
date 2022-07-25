package cn.cloudself.start.service.impl

import cn.cloudself.query.QueryProSql
import cn.cloudself.start.dao.*
import cn.cloudself.start.entity.*
import cn.cloudself.start.exception.http.PlanNotFindException
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.*
import cn.cloudself.start.service.ISysQueryService
import cn.cloudself.start.util.WebUtil
import cn.cloudself.start.util.i18n
import org.springframework.stereotype.Service

@Service
class SysQueryServiceImpl: ISysQueryService {
    override fun get(tag: String): SysQueryRes {
        val sysQuery = SysQueryQueryPro.selectBy().tag.equalsTo(tag).runLimit1()
            ?: throw PlanNotFindException("找不到tag: {}对应的查询方案配置", tag)
        val sysQueryElements = SysQueryElementQueryPro.selectBy().sysQueryId.equalsTo(sysQuery.id!!).run()
        return SysQueryRes(sysQuery, sysQueryElements)
    }

    override fun getPlan(tag: String, pageTag: String): SysQueryUserPlanRes {
        val userId = WebUtil.getUserIdNonNull()
        val sysQueryId = SysQueryQueryPro.selectBy().tag.equalsTo(tag).columnLimiter().id().firstOrNull()
            ?: throw PlanNotFindException("找不到tag: {}对应的查询方案配置", tag)

        val sysQueryElements = SysQueryElementQueryPro.selectBy().sysQueryId.equalsTo(sysQueryId).run()

        val userPlanList: List<SysQueryUserPlanEntity> = SysQueryUserPlanQueryPro
            .selectBy().pageTag.equalsTo(pageTag)
            .and().parLeft().sysUserId.equalsTo(userId).or().public.equalsTo(true).parRight()
            .run()

        val userPlanIdList: List<Long> = userPlanList.map { it.id!! }
        val userPlanItems: List<SysQueryUserPlanItemEntity> = SysQueryUserPlanItemQueryPro
            .selectBy().sysQueryUserPlanId(userPlanIdList)
            .run()

        val userPlans = userPlanList.map {
            SysQueryUserPlan(it, userPlanItems.filter { item -> item.sysQueryUserPlanId == it.id })
        }.ifEmpty {
            val defPlan = SysQueryUserPlanEntity(id = -1, name = i18n("默认方案").toString(), default = true)
            listOf(SysQueryUserPlan(defPlan, listOf()))
        }

        val sysQueryColumns = SysQueryUserTableColumnQueryPro
            .selectBy().pageTag.equalsTo(pageTag)
            .and().sysUserId.equalsTo(userId)
            .run()

        return SysQueryUserPlanRes(userPlans, sysQueryElements, sysQueryColumns)
    }

    override fun getData(searchQuery: SysQueryDataReq): Async<SysQueryDataRes> {
        val tag = searchQuery.tag
        val query: SysQueryEntity = SysQueryQueryPro.selectBy().tag.equalsTo(tag).runLimit1()
            ?: throw RequestBadException(i18n("找不到tag: {}对应的查询方案配置", tag))

        val sqlBuilder = StringBuilder(query.sqlColumn)
        val paramsList = mutableListOf<Any?>()
        sqlBuilder.append('\n')
        // 添加条件
        val conditions = searchQuery.conditions
        val columnIds: List<Long> = conditions.map { it.column_id }.filter { it > 0 }
        val configColumns: List<SysQueryElementEntity> = SysQueryElementQueryPro
            .selectBy().id(columnIds)
            .and().sysQueryId.equalsTo(query.id!!)
            .run()
        fun parseConditions(conditions: List<SysQueryCondition>) {
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
                val columnDb = configColumns.find { it.id == condition.column_id }
                val operatorsStrDb = columnDb?.limitConditions ?: throw ServerException(i18n("[BUG] sys_search_config_column数据库配置错误 {}"))
                val operatorsDb = operatorsStrDb.split(",")
                if (operatorsDb.indexOf(operator) < 0) {
                    throw RequestBadException(i18n("查询方案中不存在对应的操作符{}, 无法查询", operator))
                }
                sqlBuilder.append(columnDb.alias)
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
        val orderBys = searchQuery.orderBys
        if (orderBys.isNotEmpty()) {
            sqlBuilder.append(" order by ")
            for (orderBy in orderBys) {
                val ascDesc = if (orderBy.asc) " asc" else " desc"
                val column = configColumns.find { it.id == orderBy.column_id }?.sqlColumn
                    ?: throw RequestBadException(i18n("查询方案{}中不存在id为{}的element", tag, orderBy.column_id))
                sqlBuilder.append(column, ascDesc, ", ")
            }
            sqlBuilder.delete(sqlBuilder.length - 2, sqlBuilder.length)
        }
        // 添加分页信息
        val page = searchQuery.page
        val pageSize = searchQuery.pageSize
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
            // 查询总数，客户端支持的情况下，查询结果会优先返回，数据条数延期返回
            val totalCountPromise: Async.Promise<Int> = if (hasNext) it.create {
                val sqlForCountWithConditions = "SELECT COUNT(*) FROM ($sqlForCount) t"
                val count = QueryProSql.create(sqlForCountWithConditions, params).queryOne(Int::class.java)
                    ?: throw ServerException(i18n("无法完成count查询, {}", sqlForCountWithConditions))
                count
            } else it.just(first + rows.size)

            SysQueryDataRes(hasNext, totalCountPromise, rows)
        }
    }
}