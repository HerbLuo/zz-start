@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSearchConfigEntity
import java.util.Date
import cn.cloudself.query.*

class ImplSysSearchConfigQueryPro {
    companion object {
        const val TABLE_NAME = "sys_search_config"
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
        val name = createWhereField("name")
        fun name(nameList: List<String>) = createWhereField("name", nameList.toTypedArray())
        fun name(vararg names: String) = createWhereField("name", names)
        val nameCn = createWhereField("name_cn")
        fun nameCn(nameCnList: List<String>) = createWhereField("name_cn", nameCnList.toTypedArray())
        fun nameCn(vararg nameCns: String) = createWhereField("name_cn", nameCns)
        val sql = createWhereField("sql")
        fun sql(sqlList: List<String>) = createWhereField("sql", sqlList.toTypedArray())
        fun sql(vararg sqls: String) = createWhereField("sql", sqls)
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
        fun name() = createOrderByField("name")
        fun nameCn() = createOrderByField("name_cn")
        fun sql() = createOrderByField("sql")
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
        fun name() = getColumn(createField("name"), String::class.java)
        fun nameCn() = getColumn(createField("name_cn"), String::class.java)
        fun sql() = getColumn(createField("sql"), String::class.java)
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
        fun name() = createColumnsLimiterField("name")
        fun nameCn() = createColumnsLimiterField("name_cn")
        fun sql() = createColumnsLimiterField("sql")
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
        fun name(name: Any) = createUpdateSetField("name", name)
        fun nameCn(nameCn: Any) = createUpdateSetField("name_cn", nameCn)
        fun sql(sql: Any) = createUpdateSetField("sql", sql)
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
        fun name() = this.also { fields.add(createField("name")) }
        fun nameCn() = this.also { fields.add(createField("name_cn")) }
        fun sql() = this.also { fields.add(createField("sql")) }
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
            SysSearchConfigEntity,
            Long,
            ImplSysSearchConfigQueryPro.WhereField<SysSearchConfigEntity, List<SysSearchConfigEntity>>,
            ImplSysSearchConfigQueryPro.OrderByField<SysSearchConfigEntity, List<SysSearchConfigEntity>>,
            ImplSysSearchConfigQueryPro.UpdateSetField,
            ImplSysSearchConfigQueryPro.WhereField<Boolean, Boolean>,
            ImplSysSearchConfigQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysSearchConfigEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysSearchConfigQueryPro.WhereField(qs, SysSearchConfigEntity::class.java) },
        { qs: QueryStructure -> ImplSysSearchConfigQueryPro.OrderByField(qs, SysSearchConfigEntity::class.java) },
        { qs: QueryStructure -> ImplSysSearchConfigQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysSearchConfigQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysSearchConfigQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysSearchConfigQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysSearchConfigQueryPro.TABLE_NAME)))

val SysSearchConfigQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysSearchConfigQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysSearchConfigQueryPro.WhereField<SysSearchConfigEntity, List<SysSearchConfigEntity>>(qs, SysSearchConfigEntity::class.java) },
    { ImplSysSearchConfigQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
