package cn.cloudself.start.pojo

data class SysSearchQueryCondition(
    var condition: String,
    var value: String,
    var column_id: Long,
    var column_sql: String, // 该字段无用，但建议传入（因为可以增加可读性）
)

data class SysSearchQueryReq(
    var tag: String,
    var page: Int,
    var pageSize: Int,
    var conditions: List<SysSearchQueryCondition>,

    var orderBy: String?,
    var asc: Boolean = true,
)
