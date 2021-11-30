package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.*
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.pojo.SysSearchUserPlanRes
import cn.cloudself.start.service.ISearchConfigService
import cn.cloudself.start.util.WebUtil
import org.springframework.stereotype.Service

@Service
class SearchConfigServiceImpl: ISearchConfigService {
    override fun getPlan(planName: String): List<SysSearchUserPlanRes> {
        val userId = WebUtil.getUserIdNonNull()
        val searchConfigId = SysSearchConfigQueryPro.selectBy().name.equalsTo(planName).columnLimiter().id().firstOrNull()
            ?: throw RequestBadException("找不到PlanName: ${planName}对应的查询方案配置")

        val userPlanList = SysSearchUserPlanQueryPro
            .selectBy().sysUserId.equalsTo(userId)
            .and().sysSearchConfigId.equalsTo(searchConfigId)
            .run()

        val userPlanIdList: List<Long> = userPlanList.map { it.id!! }
        val userPlanItems = SysSearchUserPlanItemQueryPro
            .selectBy().sysSearchUserPlanId(userPlanIdList)
            .run()

        return userPlanList.map {
            SysSearchUserPlanRes(it, userPlanItems.filter { item -> item.sysSearchUserPlanId == it.id })
        }
    }
}