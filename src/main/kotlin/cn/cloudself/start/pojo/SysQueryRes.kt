package cn.cloudself.start.pojo

import cn.cloudself.start.interactive.res.Async

data class SysQueryRes(
    val hasNext: Boolean,
    val total: Async.Promise<Int>,
    val rows: List<Map<*, *>>,
)
