package cn.cloudself.start.service

import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.SysSearchQueryReq
import cn.cloudself.start.pojo.SysSearchQueryRes
import cn.cloudself.start.pojo.SysSearchUserPlanRes

interface ISysSearchPlanService {
    fun getPlan(tag: String): List<SysSearchUserPlanRes>

    fun getData(searchQuery: SysSearchQueryReq): Async<SysSearchQueryRes>
}