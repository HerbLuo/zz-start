package cn.cloudself.start.service

import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.SysQueryReq
import cn.cloudself.start.pojo.SysQueryRes
import cn.cloudself.start.pojo.SysQueryUserPlanRes

interface ISysQueryUserPlanService {
    fun getPlan(tag: String): List<SysQueryUserPlanRes>

    fun getData(searchQuery: SysQueryReq): Async<SysQueryRes>
}