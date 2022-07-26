package cn.cloudself.start.service

import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.SysQueryDataReq
import cn.cloudself.start.pojo.SysQueryDataRes
import cn.cloudself.start.pojo.SysQueryRes
import cn.cloudself.start.pojo.SysQueryUserPlanRes

interface ISysQueryService {
    fun get(tag: String): SysQueryRes

    fun getPlan(pageTag: String): SysQueryUserPlanRes

    fun getData(searchQuery: SysQueryDataReq): Async<SysQueryDataRes>
}