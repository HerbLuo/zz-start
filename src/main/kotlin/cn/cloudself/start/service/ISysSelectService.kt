package cn.cloudself.start.service

import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.pojo.SysSpDataReq
import cn.cloudself.start.pojo.SysSpDataRes
import cn.cloudself.start.pojo.SysSpRes
import cn.cloudself.start.pojo.SysSpUsrPlanRes

interface ISysSelectService {
    fun get(tag: String): SysSpRes

    fun getPlan(pageTag: String): SysSpUsrPlanRes

    fun getData(selectReq: SysSpDataReq): Async<SysSpDataRes>
}