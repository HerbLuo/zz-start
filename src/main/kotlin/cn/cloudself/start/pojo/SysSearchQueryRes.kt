package cn.cloudself.start.pojo

import cn.cloudself.start.interactive.res.Promise

data class SysSearchQueryRes(
    val hasNext: Boolean,
    val total: Promise<Int>,
    val rows: List<Map<*, *>>,
)
