package cn.cloudself.start.pojo

import cn.cloudself.start.entity.*
import cn.cloudself.start.interactive.res.Async

data class SysSelectRes(
    val query: SysSpEntity,
    val elements: List<SysSpEleEntity>
)

data class SysSelectUserPlan(
    val plan: SysSpUsrPlanEntity,
    val items: List<SysSpUsrPlanItemEntity>,
)

data class SysSelectUserPlanRes(
    val pageTag: String,
    val plans: List<SysSelectUserPlan>,
    val elements: List<SysSpEleEntity>,
    val columns: List<SysSpUsrTblColEntity>,
)

data class SysSelectDataRes(
    val hasNext: Boolean,
    val total: Async.Promise<Int>,
    val rows: List<Map<*, *>>,
)
