package cn.cloudself.start.pojo

import cn.cloudself.start.entity.SysQueryUserPlanEntity
import cn.cloudself.start.entity.SysQueryUserPlanItemEntity

data class SysQueryUserPlanRes(
    val plan: SysQueryUserPlanEntity,
    val items: List<SysQueryUserPlanItemEntity>,
)