@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSearchConfigColumnEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;

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
        @Contract(pure = true)
        fun id(idList: List<Long>) = createWhereField("id", idList.toTypedArray())
        @Contract(pure = true)
        fun id(vararg ids: Long) = createWhereField("id", ids.toTypedArray())
        val sysSearchConfigId = createWhereField("sys_search_config_id")
        @Contract(pure = true)
        fun sysSearchConfigId(sysSearchConfigIdList: List<Long>) = createWhereField("sys_search_config_id", sysSearchConfigIdList.toTypedArray())
        @Contract(pure = true)
        fun sysSearchConfigId(vararg sysSearchConfigIds: Long) = createWhereField("sys_search_config_id", sysSearchConfigIds.toTypedArray())
        val sysSearchConfigNameRedundant = createWhereField("sys_search_config_name_redundant")
        @Contract(pure = true)
        fun sysSearchConfigNameRedundant(sysSearchConfigNameRedundantList: List<String>) = createWhereField("sys_search_config_name_redundant", sysSearchConfigNameRedundantList.toTypedArray())
        @Contract(pure = true)
        fun sysSearchConfigNameRedundant(vararg sysSearchConfigNameRedundants: String) = createWhereField("sys_search_config_name_redundant", sysSearchConfigNameRedundants)
        val column = createWhereField("column")
        @Contract(pure = true)
        fun column(columnList: List<String>) = createWhereField("column", columnList.toTypedArray())
        @Contract(pure = true)
        fun column(vararg columns: String) = createWhereField("column", columns)
        val columnName = createWhereField("column_name")
        @Contract(pure = true)
        fun columnName(columnNameList: List<String>) = createWhereField("column_name", columnNameList.toTypedArray())
        @Contract(pure = true)
        fun columnName(vararg columnNames: String) = createWhereField("column_name", columnNames)
        val columnSql = createWhereField("column_sql")
        @Contract(pure = true)
        fun columnSql(columnSqlList: List<String>) = createWhereField("column_sql", columnSqlList.toTypedArray())
        @Contract(pure = true)
        fun columnSql(vararg columnSqls: String) = createWhereField("column_sql", columnSqls)
        val type = createWhereField("type")
        @Contract(pure = true)
        fun type(typeList: List<String>) = createWhereField("type", typeList.toTypedArray())
        @Contract(pure = true)
        fun type(vararg types: String) = createWhereField("type", types)
        val conditions = createWhereField("conditions")
        @Contract(pure = true)
        fun conditions(conditionsList: List<String>) = createWhereField("conditions", conditionsList.toTypedArray())
        @Contract(pure = true)
        fun conditions(vararg conditionss: String) = createWhereField("conditions", conditionss)
        val limitType = createWhereField("limit_type")
        @Contract(pure = true)
        fun limitType(limitTypeList: List<String>) = createWhereField("limit_type", limitTypeList.toTypedArray())
        @Contract(pure = true)
        fun limitType(vararg limitTypes: String) = createWhereField("limit_type", limitTypes)
        val sort = createWhereField("sort")
        @Contract(pure = true)
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        @Contract(pure = true)
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
        val hidden = createWhereField("hidden")
        @Contract(pure = true)
        fun hidden(hiddenList: List<Boolean>) = createWhereField("hidden", hiddenList.toTypedArray())
        @Contract(pure = true)
        fun hidden(vararg hiddens: Boolean) = createWhereField("hidden", hiddens.toTypedArray())
        val orderByColumn = createWhereField("order_by")
        @Contract(pure = true)
        fun orderByColumn(orderByColumnList: List<Boolean>) = createWhereField("order_by", orderByColumnList.toTypedArray())
        @Contract(pure = true)
        fun orderByColumn(vararg orderByColumns: Boolean) = createWhereField("order_by", orderByColumns.toTypedArray())
        val orderByDesc = createWhereField("order_by_desc")
        @Contract(pure = true)
        fun orderByDesc(orderByDescList: List<Boolean>) = createWhereField("order_by_desc", orderByDescList.toTypedArray())
        @Contract(pure = true)
        fun orderByDesc(vararg orderByDescs: Boolean) = createWhereField("order_by_desc", orderByDescs.toTypedArray())
        val limitValues = createWhereField("limit_values")
        @Contract(pure = true)
        fun limitValues(limitValuesList: List<String>) = createWhereField("limit_values", limitValuesList.toTypedArray())
        @Contract(pure = true)
        fun limitValues(vararg limitValuess: String) = createWhereField("limit_values", limitValuess)
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
        fun sysSearchConfigId() = createOrderByField("sys_search_config_id")
        @Contract(pure = true)
        fun sysSearchConfigNameRedundant() = createOrderByField("sys_search_config_name_redundant")
        @Contract(pure = true)
        fun column() = createOrderByField("column")
        @Contract(pure = true)
        fun columnName() = createOrderByField("column_name")
        @Contract(pure = true)
        fun columnSql() = createOrderByField("column_sql")
        @Contract(pure = true)
        fun type() = createOrderByField("type")
        @Contract(pure = true)
        fun conditions() = createOrderByField("conditions")
        @Contract(pure = true)
        fun limitType() = createOrderByField("limit_type")
        @Contract(pure = true)
        fun sort() = createOrderByField("sort")
        @Contract(pure = true)
        fun hidden() = createOrderByField("hidden")
        @Contract(pure = true)
        fun orderByColumn() = createOrderByField("order_by")
        @Contract(pure = true)
        fun orderByDesc() = createOrderByField("order_by_desc")
        @Contract(pure = true)
        fun limitValues() = createOrderByField("limit_values")
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
        fun sysSearchConfigId() = getColumn(createField("sys_search_config_id"), Long::class.java)
        fun sysSearchConfigNameRedundant() = getColumn(createField("sys_search_config_name_redundant"), String::class.java)
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

        @Contract(pure = true)
        fun id() = createColumnsLimiterField("id")
        @Contract(pure = true)
        fun sysSearchConfigId() = createColumnsLimiterField("sys_search_config_id")
        @Contract(pure = true)
        fun sysSearchConfigNameRedundant() = createColumnsLimiterField("sys_search_config_name_redundant")
        @Contract(pure = true)
        fun column() = createColumnsLimiterField("column")
        @Contract(pure = true)
        fun columnName() = createColumnsLimiterField("column_name")
        @Contract(pure = true)
        fun columnSql() = createColumnsLimiterField("column_sql")
        @Contract(pure = true)
        fun type() = createColumnsLimiterField("type")
        @Contract(pure = true)
        fun conditions() = createColumnsLimiterField("conditions")
        @Contract(pure = true)
        fun limitType() = createColumnsLimiterField("limit_type")
        @Contract(pure = true)
        fun sort() = createColumnsLimiterField("sort")
        @Contract(pure = true)
        fun hidden() = createColumnsLimiterField("hidden")
        @Contract(pure = true)
        fun orderByColumn() = createColumnsLimiterField("order_by")
        @Contract(pure = true)
        fun orderByDesc() = createColumnsLimiterField("order_by_desc")
        @Contract(pure = true)
        fun limitValues() = createColumnsLimiterField("limit_values")
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
        fun sysSearchConfigId(sysSearchConfigId: Any) = createUpdateSetField("sys_search_config_id", sysSearchConfigId)
        @Contract(pure = true)
        fun sysSearchConfigNameRedundant(sysSearchConfigNameRedundant: Any) = createUpdateSetField("sys_search_config_name_redundant", sysSearchConfigNameRedundant)
        @Contract(pure = true)
        fun column(column: Any) = createUpdateSetField("column", column)
        @Contract(pure = true)
        fun columnName(columnName: Any) = createUpdateSetField("column_name", columnName)
        @Contract(pure = true)
        fun columnSql(columnSql: Any) = createUpdateSetField("column_sql", columnSql)
        @Contract(pure = true)
        fun type(type: Any) = createUpdateSetField("type", type)
        @Contract(pure = true)
        fun conditions(conditions: Any) = createUpdateSetField("conditions", conditions)
        @Contract(pure = true)
        fun limitType(limitType: Any) = createUpdateSetField("limit_type", limitType)
        @Contract(pure = true)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
        @Contract(pure = true)
        fun hidden(hidden: Any) = createUpdateSetField("hidden", hidden)
        @Contract(pure = true)
        fun orderByColumn(orderByColumn: Any) = createUpdateSetField("order_by", orderByColumn)
        @Contract(pure = true)
        fun orderByDesc(orderByDesc: Any) = createUpdateSetField("order_by_desc", orderByDesc)
        @Contract(pure = true)
        fun limitValues(limitValues: Any) = createUpdateSetField("limit_values", limitValues)
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
        fun sysSearchConfigId() = this.also { fields.add(createField("sys_search_config_id")) }
        fun sysSearchConfigNameRedundant() = this.also { fields.add(createField("sys_search_config_name_redundant")) }
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
