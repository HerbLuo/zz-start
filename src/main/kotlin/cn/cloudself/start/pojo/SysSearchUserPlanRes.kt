package cn.cloudself.start.pojo

import cn.cloudself.start.entity.SysQueryUserPlanEntity
import cn.cloudself.start.entity.SysQueryUserPlanItemEntity

data class SysSearchUserPlanRes(
    val plan: SysQueryUserPlanEntity,
    val items: List<SysQueryUserPlanItemEntity>,
)