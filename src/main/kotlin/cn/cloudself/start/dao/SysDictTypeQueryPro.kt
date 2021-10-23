@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysDictTypeEntity
import java.util.Date
import cn.cloudself.query.*

class ImplSysDictTypeQueryPro {
    companion object {
        const val TABLE_NAME = "sys_dict_type"
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
        val name = createWhereField("name")
        fun name(vararg names: Any) = createWhereField("name", names)
        val type = createWhereField("type")
        fun type(vararg types: Any) = createWhereField("type", types)
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
        fun name() = createOrderByField("name")
        fun type() = createOrderByField("type")
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
        fun type() = getColumn(createField("type"), String::class.java)
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
        fun type() = createColumnsLimiterField("type")
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
        fun type(type: Any) = createUpdateSetField("type", type)
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
        fun type() = this.also { fields.add(createField("type")) }
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
            SysDictTypeEntity,
            Long,
            ImplSysDictTypeQueryPro.WhereField<SysDictTypeEntity, List<SysDictTypeEntity>>,
            ImplSysDictTypeQueryPro.OrderByField<SysDictTypeEntity, List<SysDictTypeEntity>>,
            ImplSysDictTypeQueryPro.UpdateSetField,
            ImplSysDictTypeQueryPro.WhereField<Boolean, Boolean>,
            ImplSysDictTypeQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysDictTypeEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysDictTypeQueryPro.WhereField(qs, SysDictTypeEntity::class.java) },
        { qs: QueryStructure -> ImplSysDictTypeQueryPro.OrderByField(qs, SysDictTypeEntity::class.java) },
        { qs: QueryStructure -> ImplSysDictTypeQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysDictTypeQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysDictTypeQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysDictTypeQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysDictTypeQueryPro.TABLE_NAME)))

val SysDictTypeQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysDictTypeQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysDictTypeQueryPro.WhereField<SysDictTypeEntity, List<SysDictTypeEntity>>(qs, SysDictTypeEntity::class.java) },
    { ImplSysDictTypeQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
