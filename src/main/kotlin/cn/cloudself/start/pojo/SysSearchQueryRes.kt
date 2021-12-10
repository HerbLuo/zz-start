package cn.cloudself.start.pojo

data class SysSearchQueryRes(
    val hasNext: Boolean,
//    val total: Promise<Int>,
    val rows: List<Map<*, *>>,
)
