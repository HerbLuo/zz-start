package cn.cloudself.start.pojo

/**
 * =
 * like "upper(column_sql) like upper('%$value%')"
 *
 * condition
 * 如何传如or结构
 * [
 *   { column_id: 1, column_sql: "age", operator: "=", value: 18 },
 *   { column_id: 0, operator: "or" },
 *   { column_id: 0, operator: "()", value: [{ column_id: 2, column_sql: "name", condition: "like", value: 18 }] }
 * ]
 */
data class SysSearchQueryCondition(
    var operator: String,
    var value: Any?,
    var conditions: List<SysSearchQueryCondition>?,
    var column_id: Long,
    var column_sql: String?, // 该字段无用，但建议传入（因为可以增加可读性）
)

data class SysSearchQueryReq(
    var tag: String,
    var page: Int,
    var pageSize: Int,
    var conditions: List<SysSearchQueryCondition>,

    var orderBy: String?,
    var asc: Boolean = true,
)
