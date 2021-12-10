package cn.cloudself.start.service.impl

import cn.cloudself.query.QueryProSql
import cn.cloudself.start.dao.SysSearchConfigColumnQueryPro
import cn.cloudself.start.dao.SysSearchConfigQueryPro
import cn.cloudself.start.dao.SysSearchUserPlanItemQueryPro
import cn.cloudself.start.dao.SysSearchUserPlanQueryPro
import cn.cloudself.start.entity.SysSearchConfigColumnEntity
import cn.cloudself.start.entity.SysSearchConfigEntity
import cn.cloudself.start.entity.SysSearchUserPlanEntity
import cn.cloudself.start.entity.SysSearchUserPlanItemEntity
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.SysSearchQueryCondition
import cn.cloudself.start.pojo.SysSearchQueryReq
import cn.cloudself.start.pojo.SysSearchQueryRes
import cn.cloudself.start.pojo.SysSearchUserPlanRes
import cn.cloudself.start.service.ISysSearchPlanService
import cn.cloudself.start.util.WebUtil
import cn.cloudself.start.util.i18n
import org.springframework.stereotype.Service

@Service
class SysSearchPlanServiceImpl: ISysSearchPlanService {

    override fun getPlan(tag: String): List<SysSearchUserPlanRes> {
        val userId = WebUtil.getUserIdNonNull()
        val searchConfigId = SysSearchConfigQueryPro.selectBy().tag.equalsTo(tag).columnLimiter().id().firstOrNull()
            ?: throw RequestBadException(i18n("找不到tag: {}对应的查询方案配置", tag))

        val userPlanList: List<SysSearchUserPlanEntity> = SysSearchUserPlanQueryPro
            .selectBy().sysUserId.equalsTo(userId)
            .and().sysSearchConfigId.equalsTo(searchConfigId)
            .run()

        val userPlanIdList: List<Long> = userPlanList.map { it.id!! }
        val userPlanItems: List<SysSearchUserPlanItemEntity> = SysSearchUserPlanItemQueryPro
            .selectBy().sysSearchUserPlanId(userPlanIdList)
            .run()

        return userPlanList.map {
            SysSearchUserPlanRes(it, userPlanItems.filter { item -> item.sysSearchUserPlanId == it.id })
        }
    }

    override fun getData(searchQuery: SysSearchQueryReq): SysSearchQueryRes {
        val tag = searchQuery.tag
        val config: SysSearchConfigEntity = SysSearchConfigQueryPro.selectBy().tag.equalsTo(tag).or() .runLimit1()
            ?: throw RequestBadException(i18n("找不到tag: {}对应的查询方案配置", tag))

        val sqlBuilder = StringBuilder(config.sql!!)
        val paramsList = mutableListOf<Any?>()
        sqlBuilder.append('\n')
        // 添加条件
        val conditions = searchQuery.conditions
        val columnIds: List<Long> = conditions.map { it.column_id }.filter { it > 0 }
        val configColumns: List<SysSearchConfigColumnEntity> = SysSearchConfigColumnQueryPro.selectBy().id(columnIds).run()
        sqlBuilder.append(" and (")
        fun parseConditions(conditions: List<SysSearchQueryCondition>) {
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
                val operatorsStrDb = columnDb?.conditions ?: throw ServerException(i18n("[BUG] sys_search_config_column数据库配置错误 {}"))
                val operatorsDb = operatorsStrDb.split(",")
                if (operatorsDb.indexOf(operator) < 0) {
                    throw RequestBadException(i18n("查询方案中不存在对应的操作符{}, 无法查询", operator))
                }
                sqlBuilder.append(columnDb.column)
                sqlBuilder.append(" ", operator, " ?")
                paramsList.add(condition.value)
            }
        }
        parseConditions(conditions)
        sqlBuilder.append(")")
        val sqlForCount = sqlBuilder.toString()
        // 查询语句
        // 添加order by
        val orderBy = searchQuery.orderBy
        if (orderBy != null) {
            val ascDesc = if (searchQuery.asc) " asc" else " desc"
            sqlBuilder.append(" order by ", orderBy, ascDesc)
        }
        // 添加分页信息
        val page = searchQuery.page
        val pageSize = searchQuery.pageSize
        val first = if (pageSize == -1) 0 else (page - 1) * pageSize
        if (pageSize != -1) {
            sqlBuilder.append(" limit ", first, ", ", pageSize + 1)
        }
        val params = paramsList.toTypedArray()
        val withNextPageRows = QueryProSql.create(sqlBuilder.toString(), params).query(Map::class.java)
        val hasNext = withNextPageRows.size > pageSize
        val rows = if (hasNext) {
            withNextPageRows.dropLast(1)
        } else {
            withNextPageRows
        }

        // 查询总数
//        val totalCountPromise: Promise<Int> = if (hasNext) Promise.create {
//            val sqlForCountWithConditions = "SELECT COUNT(*) FROM ($sqlForCount)"
//            val count = QueryProSql.create(sqlForCountWithConditions, params).queryOne(Int::class.java)
//                ?: throw ServerException(message = "无法完成count查询, $sqlForCountWithConditions")
//            count
//        } else Promise.resolve(first + rows.size)

        return SysSearchQueryRes(hasNext,
//            totalCountPromise,
            rows)
    }
}