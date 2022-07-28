package cn.cloudself.start.pojo

import cn.cloudself.start.entity.*
import cn.cloudself.start.interactive.res.Async

data class SysSelectRes(
    val query: SysSelectEntity,
    val elements: List<SysSelectElementEntity>
)

data class SysSelectUserPlan(
    val plan: SysSelectUserPlanEntity,
    val items: List<SysSelectUserPlanItemEntity>,
)

data class SysSelectUserPlanRes(
    val plans: List<SysSelectUserPlan>,
    val elements: List<SysSelectElementEntity>,
    val columns: List<SysSelectUserTableColumnEntity>,
)

data class SysSelectDataRes(
    val hasNext: Boolean,
    val total: Async.Promise<Int>,
    val rows: List<Map<*, *>>,
)
