@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSelectOptionEntity
import java.util.Date
import cn.cloudself.query.*

class ImplSysSelectOptionQueryPro {
    companion object {
        const val TABLE_NAME = "sys_select_option"
        private fun createField(column: String) = Field(TABLE_NAME, column)
    }

    abstract class CommonField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>)
        : QueryField<T, RUN_RES, WhereField<T, RUN_RES>, OrderByField<T, RUN_RES>, ColumnLimiterField<T, RUN_RES>, ColumnsLimiterField<T, RUN_RES>>(queryStructure, field_clazz) {
        override val create_where_field: CreateQueryField<WhereField<T, RUN_RES>> = { queryStructure -> WhereField(queryStructure, field_clazz) }
        override val create_order_by_field: CreateQueryField<OrderByField<T, RUN_RES>> = { queryStructure -> OrderByField(queryStructure, field_clazz) }
        override val create_column_limiter_field: CreateQueryField<ColumnLimiterField<T, RUN_RES>> =
            { queryStructure -> ColumnLimiterField(queryStructure, field_clazz) }
        override val create_columns_limiter_field: CreateQueryField<ColumnsLimiterField<T, RUN_RES>> =
            { queryStructure -> ColumnsLimiterField(queryStructure, field_clazz) }
    }

    class WhereField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.WHERE_FIELD

        private fun createWhereField(column: String) =
            QueryKeywords(createField(column), queryStructure, create_where_field)

        private fun createWhereField(column: String, objs: Array<out Any>) =
            createWhereField(column).let { if (objs.size == 1) it.equalsTo(objs[0]) else it.`in`(*objs) }

        val id = createWhereField("id")
        fun id(vararg ids: Any) = createWhereField("id", ids)
        val key = createWhereField("key")
        fun key(vararg keys: Any) = createWhereField("key", keys)
        val table = createWhereField("table")
        fun table(vararg tables: Any) = createWhereField("table", tables)
        val label = createWhereField("label")
        fun label(vararg labels: Any) = createWhereField("label", labels)
        val value = createWhereField("value")
        fun value(vararg values: Any) = createWhereField("value", values)
        val whereClause = createWhereField("where_clause")
        fun whereClause(vararg whereClauses: Any) = createWhereField("where_clause", whereClauses)
        val defaultClause = createWhereField("default_clause")
        fun defaultClause(vararg defaultClauses: Any) = createWhereField("default_clause", defaultClauses)
        val orderByClause = createWhereField("order_by_clause")
        fun orderByClause(vararg orderByClauses: Any) = createWhereField("order_by_clause", orderByClauses)
        val payload = createWhereField("payload")
        fun payload(vararg payloads: Any) = createWhereField("payload", payloads)
        val status = createWhereField("status")
        fun status(vararg statuss: Any) = createWhereField("status", statuss)
        val createBy = createWhereField("create_by")
        fun createBy(vararg createBys: Any) = createWhereField("create_by", createBys)
        val createTime = createWhereField("create_time")
        fun createTime(vararg createTimes: Any) = createWhereField("create_time", createTimes)
        val updateBy = createWhereField("update_by")
        fun updateBy(vararg updateBys: Any) = createWhereField("update_by", updateBys)
        val updateTime = createWhereField("update_time")
        fun updateTime(vararg updateTimes: Any) = createWhereField("update_time", updateTimes)
        val deleted = createWhereField("deleted")
        fun deleted(vararg deleteds: Any) = createWhereField("deleted", deleteds)
        val remark = createWhereField("remark")
        fun remark(vararg remarks: Any) = createWhereField("remark", remarks)
    }

    class OrderByField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.ORDER_BY_FIELD

        private fun createOrderByField(column: String) =
            QueryOrderByKeywords(createField(column), queryStructure, create_order_by_field)

        fun id() = createOrderByField("id")
        fun key() = createOrderByField("key")
        fun table() = createOrderByField("table")
        fun label() = createOrderByField("label")
        fun value() = createOrderByField("value")
        fun whereClause() = createOrderByField("where_clause")
        fun defaultClause() = createOrderByField("default_clause")
        fun orderByClause() = createOrderByField("order_by_clause")
        fun payload() = createOrderByField("payload")
        fun status() = createOrderByField("status")
        fun createBy() = createOrderByField("create_by")
        fun createTime() = createOrderByField("create_time")
        fun updateBy() = createOrderByField("update_by")
        fun updateTime() = createOrderByField("update_time")
        fun deleted() = createOrderByField("deleted")
        fun remark() = createOrderByField("remark")
    }

    class ColumnLimiterField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.OTHER_FIELD

        fun id() = getColumn(createField("id"), Long::class.java)
        fun key() = getColumn(createField("key"), String::class.java)
        fun table() = getColumn(createField("table"), String::class.java)
        fun label() = getColumn(createField("label"), String::class.java)
        fun value() = getColumn(createField("value"), String::class.java)
        fun whereClause() = getColumn(createField("where_clause"), String::class.java)
        fun defaultClause() = getColumn(createField("default_clause"), String::class.java)
        fun orderByClause() = getColumn(createField("order_by_clause"), String::class.java)
        fun payload() = getColumn(createField("payload"), String::class.java)
        fun status() = getColumn(createField("status"), String::class.java)
        fun createBy() = getColumn(createField("create_by"), String::class.java)
        fun createTime() = getColumn(createField("create_time"), Date::class.java)
        fun updateBy() = getColumn(createField("update_by"), String::class.java)
        fun updateTime() = getColumn(createField("update_time"), Date::class.java)
        fun deleted() = getColumn(createField("deleted"), Boolean::class.java)
        fun remark() = getColumn(createField("remark"), String::class.java)
    }

    class ColumnsLimiterField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.OTHER_FIELD

        private fun createColumnsLimiterField(column: String) =
            ColumnsLimiterField<T, RUN_RES>(queryStructure.copy(fields = queryStructure.fields + createField(column)), field_clazz)

        fun id() = createColumnsLimiterField("id")
        fun key() = createColumnsLimiterField("key")
        fun table() = createColumnsLimiterField("table")
        fun label() = createColumnsLimiterField("label")
        fun value() = createColumnsLimiterField("value")
        fun whereClause() = createColumnsLimiterField("where_clause")
        fun defaultClause() = createColumnsLimiterField("default_clause")
        fun orderByClause() = createColumnsLimiterField("order_by_clause")
        fun payload() = createColumnsLimiterField("payload")
        fun status() = createColumnsLimiterField("status")
        fun createBy() = createColumnsLimiterField("create_by")
        fun createTime() = createColumnsLimiterField("create_time")
        fun updateBy() = createColumnsLimiterField("update_by")
        fun updateTime() = createColumnsLimiterField("update_time")
        fun deleted() = createColumnsLimiterField("deleted")
        fun remark() = createColumnsLimiterField("remark")
    }

    class UpdateSetField(private val queryStructure: QueryStructure): UpdateField<WhereField<Boolean, Boolean>>(queryStructure, { qs: QueryStructure -> WhereField(qs, Boolean::class.java) }) {
        private fun createUpdateSetField(key: String, value: Any) = this.also {
            @Suppress("UNCHECKED_CAST") val map = queryStructure.update?.data as MutableMap<String, Any>
            map[key] = value
        }

        fun id(id: Any) = createUpdateSetField("id", id)
        fun key(key: Any) = createUpdateSetField("key", key)
        fun table(table: Any) = createUpdateSetField("table", table)
        fun label(label: Any) = createUpdateSetField("label", label)
        fun value(value: Any) = createUpdateSetField("value", value)
        fun whereClause(whereClause: Any) = createUpdateSetField("where_clause", whereClause)
        fun defaultClause(defaultClause: Any) = createUpdateSetField("default_clause", defaultClause)
        fun orderByClause(orderByClause: Any) = createUpdateSetField("order_by_clause", orderByClause)
        fun payload(payload: Any) = createUpdateSetField("payload", payload)
        fun status(status: Any) = createUpdateSetField("status", status)
        fun createBy(createBy: Any) = createUpdateSetField("create_by", createBy)
        fun createTime(createTime: Any) = createUpdateSetField("create_time", createTime)
        fun updateBy(updateBy: Any) = createUpdateSetField("update_by", updateBy)
        fun updateTime(updateTime: Any) = createUpdateSetField("update_time", updateTime)
        fun deleted(deleted: Any) = createUpdateSetField("deleted", deleted)
        fun remark(remark: Any) = createUpdateSetField("remark", remark)
    }


    class FieldsGenerator: FieldGenerator() {
        override val tableName = TABLE_NAME

        fun id() = this.also { fields.add(createField("id")) }
        fun key() = this.also { fields.add(createField("key")) }
        fun table() = this.also { fields.add(createField("table")) }
        fun label() = this.also { fields.add(createField("label")) }
        fun value() = this.also { fields.add(createField("value")) }
        fun whereClause() = this.also { fields.add(createField("where_clause")) }
        fun defaultClause() = this.also { fields.add(createField("default_clause")) }
        fun orderByClause() = this.also { fields.add(createField("order_by_clause")) }
        fun payload() = this.also { fields.add(createField("payload")) }
        fun status() = this.also { fields.add(createField("status")) }
        fun createBy() = this.also { fields.add(createField("create_by")) }
        fun createTime() = this.also { fields.add(createField("create_time")) }
        fun updateBy() = this.also { fields.add(createField("update_by")) }
        fun updateTime() = this.also { fields.add(createField("update_time")) }
        fun deleted() = this.also { fields.add(createField("deleted")) }
        fun remark() = this.also { fields.add(createField("remark")) }
    }
}

private fun createQuery(queryStructure: QueryStructure) =
    QueryPro<
            SysSelectOptionEntity,
            Long,
            ImplSysSelectOptionQueryPro.WhereField<SysSelectOptionEntity, List<SysSelectOptionEntity>>,
            ImplSysSelectOptionQueryPro.OrderByField<SysSelectOptionEntity, List<SysSelectOptionEntity>>,
            ImplSysSelectOptionQueryPro.UpdateSetField,
            ImplSysSelectOptionQueryPro.WhereField<Boolean, Boolean>,
            ImplSysSelectOptionQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysSelectOptionEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysSelectOptionQueryPro.WhereField(qs, SysSelectOptionEntity::class.java) },
        { qs: QueryStructure -> ImplSysSelectOptionQueryPro.OrderByField(qs, SysSelectOptionEntity::class.java) },
        { qs: QueryStructure -> ImplSysSelectOptionQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysSelectOptionQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysSelectOptionQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysSelectOptionQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysSelectOptionQueryPro.TABLE_NAME)))

val SysSelectOptionQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysSelectOptionQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysSelectOptionQueryPro.WhereField<SysSelectOptionEntity, List<SysSelectOptionEntity>>(qs, SysSelectOptionEntity::class.java) },
    { ImplSysSelectOptionQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
