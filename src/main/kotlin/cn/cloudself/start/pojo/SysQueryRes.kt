package cn.cloudself.start.pojo

import cn.cloudself.start.entity.*
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
    val columns: List<SysQueryUserTableColumnEntity>,
)

data class SysQueryDataRes(
    val hasNext: Boolean,
    val total: Async.Promise<Int>,
    val rows: List<Map<*, *>>,
)
