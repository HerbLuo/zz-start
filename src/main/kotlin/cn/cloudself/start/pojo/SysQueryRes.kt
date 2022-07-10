package cn.cloudself.start.pojo

import cn.cloudself.start.entity.SysQueryElementEntity
import cn.cloudself.start.entity.SysQueryEntity
import cn.cloudself.start.entity.SysQueryUserPlanEntity
import cn.cloudself.start.entity.SysQueryUserPlanItemEntity
import cn.cloudself.start.interactive.res.Async

data class SysQueryRes(
    val query: SysQueryEntity,
    val elements: List<SysQueryElementEntity>
)

data class SysQueryUserPlan(
    val plan: SysQueryUserPlanEntity,
    val items: List<SysQueryUserPlanItemEntity>,
)

data class SysQueryUserPlanRes(
    val plans: List<SysQueryUserPlan>,
    val elements: List<SysQueryElementEntity>,
)

data class SysQueryDataRes(
    val hasNext: Boolean,
    val total: Async.Promise<Int>,
    val rows: List<Map<*, *>>,
)
