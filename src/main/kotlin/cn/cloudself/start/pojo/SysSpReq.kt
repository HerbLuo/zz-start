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
data class SysSpDataReqCondition(
    var operator: String,
    var value: Any?,
    var conditions: List<SysSpDataReqCondition>?,
    var alias: String,
)

data class SysSpDataReqOrderBy(
    var alias: String,
    var asc: Boolean = true,
)

data class SysSpDataReq(
    var pageTag: String,
    var page: Int,
    var pageSize: Int,
    var conditions: List<SysSpDataReqCondition>,
    var columns: List<String>?,
    var orderBys: List<SysSpDataReqOrderBy>,
)
