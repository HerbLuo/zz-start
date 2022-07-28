package cn.cloudself.start.pojo

import cn.cloudself.start.entity.*
import cn.cloudself.start.interactive.res.Async

data class SysSpRes(
    val query: SysSpEntity,
    val elements: List<SysSpEleEntity>
)

data class SysSpUsrPlan(
    val plan: SysSpUsrPlanEntity,
    val items: List<SysSpUsrPlanItemEntity>,
)

data class SysSpUsrPlanRes(
    val pageTag: String,
    val plans: List<SysSpUsrPlan>,
    val elements: List<SysSpEleEntity>,
    val columns: List<SysSpUsrTblColEntity>,
)

data class SysSpDataRes(
    val hasNext: Boolean,
    val total: Async.Promise<Int>,
    val rows: List<Map<*, *>>,
)
