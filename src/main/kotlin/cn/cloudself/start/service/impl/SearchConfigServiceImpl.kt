package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysSearchConfigQueryProEx
import cn.cloudself.start.dao.SysSearchUserPlanQueryPro
import cn.cloudself.start.dao.SysSearchUserPlanQueryProEx
import cn.cloudself.start.service.ISearchConfigService
import cn.cloudself.start.util.WebUtil
import org.springframework.stereotype.Service

@Service
class SearchConfigServiceImpl: ISearchConfigService {
    override fun getPlan(planName: String) {
        val id = WebUtil.getUserIdNonNull()
        val userPlainList = SysSearchUserPlanQueryProEx
            .leftJoinOn(SysSearchUserPlanQueryProEx.joiner().sysSearchConfigId(), SysSearchConfigQueryProEx.joiner().id())
            .selectBy().sysUserId.equalsTo(id)
            .andForeignField(SysSearchConfigQueryProEx.foreignField().name.equalsTo(planName))
            .run()

    }
}