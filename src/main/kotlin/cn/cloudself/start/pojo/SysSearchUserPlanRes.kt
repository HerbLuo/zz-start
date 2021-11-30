package cn.cloudself.start.pojo

import cn.cloudself.start.entity.SysSearchUserPlanEntity
import cn.cloudself.start.entity.SysSearchUserPlanItemEntity

data class SysSearchUserPlanRes(
    var plan: SysSearchUserPlanEntity,
    var items: List<SysSearchUserPlanItemEntity>,
)