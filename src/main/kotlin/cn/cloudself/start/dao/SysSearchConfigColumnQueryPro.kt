@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSearchConfigColumnEntity
import java.util.Date
import cn.cloudself.query.*

class ImplSysSearchConfigColumnQueryPro {
    companion object {
        const val TABLE_NAME = "sys_search_config_column"
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
        fun id(idList: List<Long>) = createWhereField("id", idList.toTypedArray())
        fun id(vararg ids: Long) = createWhereField("id", ids.toTypedArray())
        val sysSearchConfigId = createWhereField("sys_search_config_id")
        fun sysSearchConfigId(sysSearchConfigIdList: List<Long>) = createWhereField("sys_search_config_id", sysSearchConfigIdList.toTypedArray())
        fun sysSearchConfigId(vararg sysSearchConfigIds: Long) = createWhereField("sys_search_config_id", sysSearchConfigIds.toTypedArray())
        val column = createWhereField("column")
        fun column(columnList: List<String>) = createWhereField("column", columnList.toTypedArray())
        fun column(vararg columns: String) = createWhereField("column", columns)
        val columnName = createWhereField("column_name")
        fun columnName(columnNameList: List<String>) = createWhereField("column_name", columnNameList.toTypedArray())
        fun columnName(vararg columnNames: String) = createWhereField("column_name", columnNames)
        val columnSql = createWhereField("column_sql")
        fun columnSql(columnSqlList: List<String>) = createWhereField("column_sql", columnSqlList.toTypedArray())
        fun columnSql(vararg columnSqls: String) = createWhereField("column_sql", columnSqls)
        val type = createWhereField("type")
        fun type(typeList: List<String>) = createWhereField("type", typeList.toTypedArray())
        fun type(vararg types: String) = createWhereField("type", types)
        val conditions = createWhereField("conditions")
        fun conditions(conditionsList: List<String>) = createWhereField("conditions", conditionsList.toTypedArray())
        fun conditions(vararg conditionss: String) = createWhereField("conditions", conditionss)
        val limitType = createWhereField("limit_type")
        fun limitType(limitTypeList: List<String>) = createWhereField("limit_type", limitTypeList.toTypedArray())
        fun limitType(vararg limitTypes: String) = createWhereField("limit_type", limitTypes)
        val sort = createWhereField("sort")
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
        val hidden = createWhereField("hidden")
        fun hidden(hiddenList: List<Boolean>) = createWhereField("hidden", hiddenList.toTypedArray())
        fun hidden(vararg hiddens: Boolean) = createWhereField("hidden", hiddens.toTypedArray())
        val orderByColumn = createWhereField("order_by")
        fun orderByColumn(orderByColumnList: List<Boolean>) = createWhereField("order_by", orderByColumnList.toTypedArray())
        fun orderByColumn(vararg orderByColumns: Boolean) = createWhereField("order_by", orderByColumns.toTypedArray())
        val orderByDesc = createWhereField("order_by_desc")
        fun orderByDesc(orderByDescList: List<Boolean>) = createWhereField("order_by_desc", orderByDescList.toTypedArray())
        fun orderByDesc(vararg orderByDescs: Boolean) = createWhereField("order_by_desc", orderByDescs.toTypedArray())
        val limitValues = createWhereField("limit_values")
        fun limitValues(limitValuesList: List<String>) = createWhereField("limit_values", limitValuesList.toTypedArray())
        fun limitValues(vararg limitValuess: String) = createWhereField("limit_values", limitValuess)
        val status = createWhereField("status")
        fun status(statusList: List<String>) = createWhereField("status", statusList.toTypedArray())
        fun status(vararg statuss: String) = createWhereField("status", statuss)
        val createBy = createWhereField("create_by")
        fun createBy(createByList: List<String>) = createWhereField("create_by", createByList.toTypedArray())
        fun createBy(vararg createBys: String) = createWhereField("create_by", createBys)
        val createTime = createWhereField("create_time")
        fun createTime(createTimeList: List<Date>) = createWhereField("create_time", createTimeList.toTypedArray())
        fun createTime(vararg createTimes: Date) = createWhereField("create_time", createTimes)
        val updateBy = createWhereField("update_by")
        fun updateBy(updateByList: List<String>) = createWhereField("update_by", updateByList.toTypedArray())
        fun updateBy(vararg updateBys: String) = createWhereField("update_by", updateBys)
        val updateTime = createWhereField("update_time")
        fun updateTime(updateTimeList: List<Date>) = createWhereField("update_time", updateTimeList.toTypedArray())
        fun updateTime(vararg updateTimes: Date) = createWhereField("update_time", updateTimes)
        val deleted = createWhereField("deleted")
        fun deleted(deletedList: List<Boolean>) = createWhereField("deleted", deletedList.toTypedArray())
        fun deleted(vararg deleteds: Boolean) = createWhereField("deleted", deleteds.toTypedArray())
        val remark = createWhereField("remark")
        fun remark(remarkList: List<String>) = createWhereField("remark", remarkList.toTypedArray())
        fun remark(vararg remarks: String) = createWhereField("remark", remarks)
    }

    class OrderByField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.ORDER_BY_FIELD

        private fun createOrderByField(column: String) =
            QueryOrderByKeywords(createField(column), queryStructure, create_order_by_field)

        fun id() = createOrderByField("id")
        fun sysSearchConfigId() = createOrderByField("sys_search_config_id")
        fun column() = createOrderByField("column")
        fun columnName() = createOrderByField("column_name")
        fun columnSql() = createOrderByField("column_sql")
        fun type() = createOrderByField("type")
        fun conditions() = createOrderByField("conditions")
        fun limitType() = createOrderByField("limit_type")
        fun sort() = createOrderByField("sort")
        fun hidden() = createOrderByField("hidden")
        fun orderByColumn() = createOrderByField("order_by")
        fun orderByDesc() = createOrderByField("order_by_desc")
        fun limitValues() = createOrderByField("limit_values")
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
        fun sysSearchConfigId() = getColumn(createField("sys_search_config_id"), Long::class.java)
        fun column() = getColumn(createField("column"), String::class.java)
        fun columnName() = getColumn(createField("column_name"), String::class.java)
        fun columnSql() = getColumn(createField("column_sql"), String::class.java)
        fun type() = getColumn(createField("type"), String::class.java)
        fun conditions() = getColumn(createField("conditions"), String::class.java)
        fun limitType() = getColumn(createField("limit_type"), String::class.java)
        fun sort() = getColumn(createField("sort"), Int::class.java)
        fun hidden() = getColumn(createField("hidden"), Boolean::class.java)
        fun orderByColumn() = getColumn(createField("order_by"), Boolean::class.java)
        fun orderByDesc() = getColumn(createField("order_by_desc"), Boolean::class.java)
        fun limitValues() = getColumn(createField("limit_values"), String::class.java)
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
        fun sysSearchConfigId() = createColumnsLimiterField("sys_search_config_id")
        fun column() = createColumnsLimiterField("column")
        fun columnName() = createColumnsLimiterField("column_name")
        fun columnSql() = createColumnsLimiterField("column_sql")
        fun type() = createColumnsLimiterField("type")
        fun conditions() = createColumnsLimiterField("conditions")
        fun limitType() = createColumnsLimiterField("limit_type")
        fun sort() = createColumnsLimiterField("sort")
        fun hidden() = createColumnsLimiterField("hidden")
        fun orderByColumn() = createColumnsLimiterField("order_by")
        fun orderByDesc() = createColumnsLimiterField("order_by_desc")
        fun limitValues() = createColumnsLimiterField("limit_values")
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
        fun sysSearchConfigId(sysSearchConfigId: Any) = createUpdateSetField("sys_search_config_id", sysSearchConfigId)
        fun column(column: Any) = createUpdateSetField("column", column)
        fun columnName(columnName: Any) = createUpdateSetField("column_name", columnName)
        fun columnSql(columnSql: Any) = createUpdateSetField("column_sql", columnSql)
        fun type(type: Any) = createUpdateSetField("type", type)
        fun conditions(conditions: Any) = createUpdateSetField("conditions", conditions)
        fun limitType(limitType: Any) = createUpdateSetField("limit_type", limitType)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
        fun hidden(hidden: Any) = createUpdateSetField("hidden", hidden)
        fun orderByColumn(orderByColumn: Any) = createUpdateSetField("order_by", orderByColumn)
        fun orderByDesc(orderByDesc: Any) = createUpdateSetField("order_by_desc", orderByDesc)
        fun limitValues(limitValues: Any) = createUpdateSetField("limit_values", limitValues)
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
        fun sysSearchConfigId() = this.also { fields.add(createField("sys_search_config_id")) }
        fun column() = this.also { fields.add(createField("column")) }
        fun columnName() = this.also { fields.add(createField("column_name")) }
        fun columnSql() = this.also { fields.add(createField("column_sql")) }
        fun type() = this.also { fields.add(createField("type")) }
        fun conditions() = this.also { fields.add(createField("conditions")) }
        fun limitType() = this.also { fields.add(createField("limit_type")) }
        fun sort() = this.also { fields.add(createField("sort")) }
        fun hidden() = this.also { fields.add(createField("hidden")) }
        fun orderByColumn() = this.also { fields.add(createField("order_by")) }
        fun orderByDesc() = this.also { fields.add(createField("order_by_desc")) }
        fun limitValues() = this.also { fields.add(createField("limit_values")) }
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
            SysSearchConfigColumnEntity,
            Long,
            ImplSysSearchConfigColumnQueryPro.WhereField<SysSearchConfigColumnEntity, List<SysSearchConfigColumnEntity>>,
            ImplSysSearchConfigColumnQueryPro.OrderByField<SysSearchConfigColumnEntity, List<SysSearchConfigColumnEntity>>,
            ImplSysSearchConfigColumnQueryPro.UpdateSetField,
            ImplSysSearchConfigColumnQueryPro.WhereField<Boolean, Boolean>,
            ImplSysSearchConfigColumnQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysSearchConfigColumnEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysSearchConfigColumnQueryPro.WhereField(qs, SysSearchConfigColumnEntity::class.java) },
        { qs: QueryStructure -> ImplSysSearchConfigColumnQueryPro.OrderByField(qs, SysSearchConfigColumnEntity::class.java) },
        { qs: QueryStructure -> ImplSysSearchConfigColumnQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysSearchConfigColumnQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysSearchConfigColumnQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysSearchConfigColumnQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysSearchConfigColumnQueryPro.TABLE_NAME)))

val SysSearchConfigColumnQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysSearchConfigColumnQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysSearchConfigColumnQueryPro.WhereField<SysSearchConfigColumnEntity, List<SysSearchConfigColumnEntity>>(qs, SysSearchConfigColumnEntity::class.java) },
    { ImplSysSearchConfigColumnQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
