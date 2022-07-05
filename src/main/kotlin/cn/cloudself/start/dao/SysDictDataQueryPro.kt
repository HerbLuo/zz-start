@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysDictDataEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


class ImplSysDictDataQueryPro {
    companion object {
        const val TABLE_NAME = "sys_dict_data"
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
        override fun getPayload() = SysDictDataQueryPro.payload
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
        val type = createWhereField("type")
        @Contract(pure = true)
        fun type(typeList: List<String>) = createWhereField("type", typeList.toTypedArray())
        @Contract(pure = true)
        fun type(vararg types: String) = createWhereField("type", types)
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
        val sort = createWhereField("sort")
        @Contract(pure = true)
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        @Contract(pure = true)
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
        val isDefault = createWhereField("is_default")
        @Contract(pure = true)
        fun isDefault(isDefaultList: List<Boolean>) = createWhereField("is_default", isDefaultList.toTypedArray())
        @Contract(pure = true)
        fun isDefault(vararg isDefaults: Boolean) = createWhereField("is_default", isDefaults.toTypedArray())
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
        fun type() = createOrderByField("type")
        @Contract(pure = true)
        fun label() = createOrderByField("label")
        @Contract(pure = true)
        fun value() = createOrderByField("value")
        @Contract(pure = true)
        fun sort() = createOrderByField("sort")
        @Contract(pure = true)
        fun isDefault() = createOrderByField("is_default")
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
        fun type() = getColumn(createField("type"), String::class.java)
        fun label() = getColumn(createField("label"), String::class.java)
        fun value() = getColumn(createField("value"), String::class.java)
        fun sort() = getColumn(createField("sort"), Int::class.java)
        fun isDefault() = getColumn(createField("is_default"), Boolean::class.java)
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
        fun type() = createColumnsLimiterField("type")
        @Contract(pure = true)
        fun label() = createColumnsLimiterField("label")
        @Contract(pure = true)
        fun value() = createColumnsLimiterField("value")
        @Contract(pure = true)
        fun sort() = createColumnsLimiterField("sort")
        @Contract(pure = true)
        fun isDefault() = createColumnsLimiterField("is_default")
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
        fun type(type: Any) = createUpdateSetField("type", type)
        @Contract(pure = true)
        fun label(label: Any) = createUpdateSetField("label", label)
        @Contract(pure = true)
        fun value(value: Any) = createUpdateSetField("value", value)
        @Contract(pure = true)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
        @Contract(pure = true)
        fun isDefault(isDefault: Any) = createUpdateSetField("is_default", isDefault)
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
        fun type() = this.also { fields.add(createField("type")) }
        fun label() = this.also { fields.add(createField("label")) }
        fun value() = this.also { fields.add(createField("value")) }
        fun sort() = this.also { fields.add(createField("sort")) }
        fun isDefault() = this.also { fields.add(createField("is_default")) }
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
            SysDictDataEntity,
            Long,
            ImplSysDictDataQueryPro.WhereField<SysDictDataEntity, List<SysDictDataEntity>>,
            ImplSysDictDataQueryPro.OrderByField<SysDictDataEntity, List<SysDictDataEntity>>,
            ImplSysDictDataQueryPro.UpdateSetField,
            ImplSysDictDataQueryPro.WhereField<Boolean, Boolean>,
            ImplSysDictDataQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysDictDataEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysDictDataQueryPro.WhereField(qs, SysDictDataEntity::class.java) },
        { qs: QueryStructure -> ImplSysDictDataQueryPro.OrderByField(qs, SysDictDataEntity::class.java) },
        { qs: QueryStructure -> ImplSysDictDataQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysDictDataQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysDictDataQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysDictDataQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysDictDataQueryPro.TABLE_NAME)))

val SysDictDataQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysDictDataQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysDictDataQueryPro.WhereField<SysDictDataEntity, List<SysDictDataEntity>>(qs, SysDictDataEntity::class.java) },
    { ImplSysDictDataQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
