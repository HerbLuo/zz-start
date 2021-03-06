@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSelectOptionEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


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
        override fun getPayload() = SysSelectOptionQueryPro.payload
    }

    class WhereField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.WHERE_FIELD

        private fun createWhereField(column: String) =
            QueryKeywords(createField(column), queryStructure, create_where_field)

        private fun createWhereField(column: String, objs: Array<out Any>) =
            createWhereField(column).let { if (objs.size == 1) it.equalsTo(objs[0]) else it.`in`(*objs) }

        val id = createWhereField("id")
        @Contract(pure = true)
        fun id(idList: List<Long>) = createWhereField("id", idList.toTypedArray())
        @Contract(pure = true)
        fun id(vararg ids: Long) = createWhereField("id", ids.toTypedArray())
        val key = createWhereField("key")
        @Contract(pure = true)
        fun key(keyList: List<String>) = createWhereField("key", keyList.toTypedArray())
        @Contract(pure = true)
        fun key(vararg keys: String) = createWhereField("key", keys)
        val table = createWhereField("table")
        @Contract(pure = true)
        fun table(tableList: List<String>) = createWhereField("table", tableList.toTypedArray())
        @Contract(pure = true)
        fun table(vararg tables: String) = createWhereField("table", tables)
        val label = createWhereField("label")
        @Contract(pure = true)
        fun label(labelList: List<String>) = createWhereField("label", labelList.toTypedArray())
        @Contract(pure = true)
        fun label(vararg labels: String) = createWhereField("label", labels)
        val value = createWhereField("value")
        @Contract(pure = true)
        fun value(valueList: List<String>) = createWhereField("value", valueList.toTypedArray())
        @Contract(pure = true)
        fun value(vararg values: String) = createWhereField("value", values)
        val whereClause = createWhereField("where_clause")
        @Contract(pure = true)
        fun whereClause(whereClauseList: List<String>) = createWhereField("where_clause", whereClauseList.toTypedArray())
        @Contract(pure = true)
        fun whereClause(vararg whereClauses: String) = createWhereField("where_clause", whereClauses)
        val defaultClause = createWhereField("default_clause")
        @Contract(pure = true)
        fun defaultClause(defaultClauseList: List<String>) = createWhereField("default_clause", defaultClauseList.toTypedArray())
        @Contract(pure = true)
        fun defaultClause(vararg defaultClauses: String) = createWhereField("default_clause", defaultClauses)
        val orderByClause = createWhereField("order_by_clause")
        @Contract(pure = true)
        fun orderByClause(orderByClauseList: List<String>) = createWhereField("order_by_clause", orderByClauseList.toTypedArray())
        @Contract(pure = true)
        fun orderByClause(vararg orderByClauses: String) = createWhereField("order_by_clause", orderByClauses)
        val payload = createWhereField("payload")
        @Contract(pure = true)
        fun payload(payloadList: List<String>) = createWhereField("payload", payloadList.toTypedArray())
        @Contract(pure = true)
        fun payload(vararg payloads: String) = createWhereField("payload", payloads)
        val status = createWhereField("status")
        @Contract(pure = true)
        fun status(statusList: List<String>) = createWhereField("status", statusList.toTypedArray())
        @Contract(pure = true)
        fun status(vararg statuss: String) = createWhereField("status", statuss)
        val createBy = createWhereField("create_by")
        @Contract(pure = true)
        fun createBy(createByList: List<String>) = createWhereField("create_by", createByList.toTypedArray())
        @Contract(pure = true)
        fun createBy(vararg createBys: String) = createWhereField("create_by", createBys)
        val createTime = createWhereField("create_time")
        @Contract(pure = true)
        fun createTime(createTimeList: List<Date>) = createWhereField("create_time", createTimeList.toTypedArray())
        @Contract(pure = true)
        fun createTime(vararg createTimes: Date) = createWhereField("create_time", createTimes)
        val updateBy = createWhereField("update_by")
        @Contract(pure = true)
        fun updateBy(updateByList: List<String>) = createWhereField("update_by", updateByList.toTypedArray())
        @Contract(pure = true)
        fun updateBy(vararg updateBys: String) = createWhereField("update_by", updateBys)
        val updateTime = createWhereField("update_time")
        @Contract(pure = true)
        fun updateTime(updateTimeList: List<Date>) = createWhereField("update_time", updateTimeList.toTypedArray())
        @Contract(pure = true)
        fun updateTime(vararg updateTimes: Date) = createWhereField("update_time", updateTimes)
        val deleted = createWhereField("deleted")
        @Contract(pure = true)
        fun deleted(deletedList: List<Boolean>) = createWhereField("deleted", deletedList.toTypedArray())
        @Contract(pure = true)
        fun deleted(vararg deleteds: Boolean) = createWhereField("deleted", deleteds.toTypedArray())
        val remark = createWhereField("remark")
        @Contract(pure = true)
        fun remark(remarkList: List<String>) = createWhereField("remark", remarkList.toTypedArray())
        @Contract(pure = true)
        fun remark(vararg remarks: String) = createWhereField("remark", remarks)
    }

    class OrderByField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.ORDER_BY_FIELD

        private fun createOrderByField(column: String) =
            QueryOrderByKeywords(createField(column), queryStructure, create_order_by_field)

        @Contract(pure = true)
        fun id() = createOrderByField("id")
        @Contract(pure = true)
        fun key() = createOrderByField("key")
        @Contract(pure = true)
        fun table() = createOrderByField("table")
        @Contract(pure = true)
        fun label() = createOrderByField("label")
        @Contract(pure = true)
        fun value() = createOrderByField("value")
        @Contract(pure = true)
        fun whereClause() = createOrderByField("where_clause")
        @Contract(pure = true)
        fun defaultClause() = createOrderByField("default_clause")
        @Contract(pure = true)
        fun orderByClause() = createOrderByField("order_by_clause")
        @Contract(pure = true)
        fun payload() = createOrderByField("payload")
        @Contract(pure = true)
        fun status() = createOrderByField("status")
        @Contract(pure = true)
        fun createBy() = createOrderByField("create_by")
        @Contract(pure = true)
        fun createTime() = createOrderByField("create_time")
        @Contract(pure = true)
        fun updateBy() = createOrderByField("update_by")
        @Contract(pure = true)
        fun updateTime() = createOrderByField("update_time")
        @Contract(pure = true)
        fun deleted() = createOrderByField("deleted")
        @Contract(pure = true)
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

        @Contract(pure = true)
        fun id() = createColumnsLimiterField("id")
        @Contract(pure = true)
        fun key() = createColumnsLimiterField("key")
        @Contract(pure = true)
        fun table() = createColumnsLimiterField("table")
        @Contract(pure = true)
        fun label() = createColumnsLimiterField("label")
        @Contract(pure = true)
        fun value() = createColumnsLimiterField("value")
        @Contract(pure = true)
        fun whereClause() = createColumnsLimiterField("where_clause")
        @Contract(pure = true)
        fun defaultClause() = createColumnsLimiterField("default_clause")
        @Contract(pure = true)
        fun orderByClause() = createColumnsLimiterField("order_by_clause")
        @Contract(pure = true)
        fun payload() = createColumnsLimiterField("payload")
        @Contract(pure = true)
        fun status() = createColumnsLimiterField("status")
        @Contract(pure = true)
        fun createBy() = createColumnsLimiterField("create_by")
        @Contract(pure = true)
        fun createTime() = createColumnsLimiterField("create_time")
        @Contract(pure = true)
        fun updateBy() = createColumnsLimiterField("update_by")
        @Contract(pure = true)
        fun updateTime() = createColumnsLimiterField("update_time")
        @Contract(pure = true)
        fun deleted() = createColumnsLimiterField("deleted")
        @Contract(pure = true)
        fun remark() = createColumnsLimiterField("remark")
    }

    class UpdateSetField(private val queryStructure: QueryStructure): UpdateField<WhereField<Boolean, Boolean>>(queryStructure, { qs: QueryStructure -> WhereField(qs, Boolean::class.java) }) {
        private fun createUpdateSetField(key: String, value: Any) = this.also {
            @Suppress("UNCHECKED_CAST") val map = queryStructure.update?.data as MutableMap<String, Any>
            map[key] = value
        }

        @Contract(pure = true)
        fun id(id: Any) = createUpdateSetField("id", id)
        @Contract(pure = true)
        fun key(key: Any) = createUpdateSetField("key", key)
        @Contract(pure = true)
        fun table(table: Any) = createUpdateSetField("table", table)
        @Contract(pure = true)
        fun label(label: Any) = createUpdateSetField("label", label)
        @Contract(pure = true)
        fun value(value: Any) = createUpdateSetField("value", value)
        @Contract(pure = true)
        fun whereClause(whereClause: Any) = createUpdateSetField("where_clause", whereClause)
        @Contract(pure = true)
        fun defaultClause(defaultClause: Any) = createUpdateSetField("default_clause", defaultClause)
        @Contract(pure = true)
        fun orderByClause(orderByClause: Any) = createUpdateSetField("order_by_clause", orderByClause)
        @Contract(pure = true)
        fun payload(payload: Any) = createUpdateSetField("payload", payload)
        @Contract(pure = true)
        fun status(status: Any) = createUpdateSetField("status", status)
        @Contract(pure = true)
        fun createBy(createBy: Any) = createUpdateSetField("create_by", createBy)
        @Contract(pure = true)
        fun createTime(createTime: Any) = createUpdateSetField("create_time", createTime)
        @Contract(pure = true)
        fun updateBy(updateBy: Any) = createUpdateSetField("update_by", updateBy)
        @Contract(pure = true)
        fun updateTime(updateTime: Any) = createUpdateSetField("update_time", updateTime)
        @Contract(pure = true)
        fun deleted(deleted: Any) = createUpdateSetField("deleted", deleted)
        @Contract(pure = true)
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
