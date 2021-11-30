package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysSearchConfigQueryPro
import cn.cloudself.start.dao.SysSearchConfigQueryProEx
import cn.cloudself.start.dao.SysSearchUserPlanQueryPro
import cn.cloudself.start.dao.SysSearchUserPlanQueryProEx
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.service.ISearchConfigService
import cn.cloudself.start.util.WebUtil
import org.springframework.stereotype.Service

@Service
class SearchConfigServiceImpl: ISearchConfigService {
    override fun getPlan(planName: String) {
        val userId = WebUtil.getUserIdNonNull()
        val searchConfigId = SysSearchConfigQueryPro.selectBy().name.equalsTo(planName).columnLimiter().id().firstOrNull()
            ?: throw RequestBadException("找不到PlanName: ${planName}对应的查询方案配置")

        val userPlainList = SysSearchUserPlanQueryPro
            .selectBy().sysUserId.equalsTo(userId)
            .and().sysSearchConfigId.equalsTo(searchConfigId)
            .run()

        println(userPlainList)

    }
}