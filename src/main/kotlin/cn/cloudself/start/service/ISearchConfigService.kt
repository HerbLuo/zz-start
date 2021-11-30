package cn.cloudself.start.service

import cn.cloudself.start.pojo.SysSearchUserPlanRes

interface ISearchConfigService {
    fun getPlan(planName: String): List<SysSearchUserPlanRes>
}