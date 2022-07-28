package cn.cloudself.start.service

import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.SysSelectDataReq
import cn.cloudself.start.pojo.SysSelectDataRes
import cn.cloudself.start.pojo.SysSelectRes
import cn.cloudself.start.pojo.SysSelectUserPlanRes

interface ISysSelectService {
    fun get(tag: String): SysSelectRes

    fun getPlan(pageTag: String): SysSelectUserPlanRes

    fun getData(selectReq: SysSelectDataReq): Async<SysSelectDataRes>
}