package cn.cloudself.start.service.impl

import cn.cloudself.query.QueryProSql
import cn.cloudself.start.dao.*
import cn.cloudself.start.entity.SysSearchConfigEntity
import cn.cloudself.start.entity.SysSearchUserPlanEntity
import cn.cloudself.start.entity.SysSearchUserPlanItemEntity
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.interactive.res.Promise
import cn.cloudself.start.pojo.SysSearchQueryReq
import cn.cloudself.start.pojo.SysSearchQueryRes
import cn.cloudself.start.pojo.SysSearchUserPlanRes
import cn.cloudself.start.service.ISysSearchPlanService
import cn.cloudself.start.util.WebUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.sql.DataSource

@Service
class SysSearchPlanServiceImpl: ISysSearchPlanService {

    override fun getPlan(tag: String): List<SysSearchUserPlanRes> {
        val userId = WebUtil.getUserIdNonNull()
        val searchConfigId = SysSearchConfigQueryPro.selectBy().tag.equalsTo(tag).columnLimiter().id().firstOrNull()
            ?: throw RequestBadException("找不到tag: ${tag}对应的查询方案配置")

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
        val config: SysSearchConfigEntity = SysSearchConfigQueryPro.selectBy().tag.equalsTo(tag).runLimit1()
            ?: throw RequestBadException("找不到tag: ${tag}对应的查询方案配置")

        val sqlBuilder = StringBuilder(config.sql!!)
        sqlBuilder.append('\n')
        // 添加条件
        val conditions = searchQuery.conditions
        for (condition in conditions) {

        }
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
        val withNextPageRows = QueryProSql.create(sqlBuilder.toString()).query(Map::class.java)
        val hasNext = withNextPageRows.size > pageSize
        val rows = if (hasNext) {
            withNextPageRows.dropLast(1)
        } else {
            withNextPageRows
        }

        // 查询总数
        val totalCountPromise: Promise<Int> = if (hasNext) Promise.create {
            val sqlForCountWithConditions = "SELECT COUNT(*) FROM ($sqlForCount)"
            val count = QueryProSql.create(sqlForCountWithConditions).queryOne(Int::class.java)
                ?: throw ServerException(message = { "无法完成count查询, $sqlForCountWithConditions" })
            count
        } else Promise.resolve(first + rows.size)

        return SysSearchQueryRes(hasNext, totalCountPromise, rows)
    }
}