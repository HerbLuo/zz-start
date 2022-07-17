@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysQueryUserPlanEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


class ImplSysQueryUserPlanQueryPro {
    companion object {
        const val TABLE_NAME = "sys_query_user_plan"
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
        override fun getPayload() = SysQueryUserPlanQueryPro.payload
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
        val sysUserId = createWhereField("sys_user_id")
        @Contract(pure = true)
        fun sysUserId(sysUserIdList: List<Long>) = createWhereField("sys_user_id", sysUserIdList.toTypedArray())
        @Contract(pure = true)
        fun sysUserId(vararg sysUserIds: Long) = createWhereField("sys_user_id", sysUserIds.toTypedArray())
        val sysQueryId = createWhereField("sys_query_id")
        @Contract(pure = true)
        fun sysQueryId(sysQueryIdList: List<Long>) = createWhereField("sys_query_id", sysQueryIdList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryId(vararg sysQueryIds: Long) = createWhereField("sys_query_id", sysQueryIds.toTypedArray())
        val sysQueryTagCnRedundant = createWhereField("sys_query_tag_cn_redundant")
        @Contract(pure = true)
        fun sysQueryTagCnRedundant(sysQueryTagCnRedundantList: List<String>) = createWhereField("sys_query_tag_cn_redundant", sysQueryTagCnRedundantList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryTagCnRedundant(vararg sysQueryTagCnRedundants: String) = createWhereField("sys_query_tag_cn_redundant", sysQueryTagCnRedundants)
        val name = createWhereField("name")
        @Contract(pure = true)
        fun name(nameList: List<String>) = createWhereField("name", nameList.toTypedArray())
        @Contract(pure = true)
        fun name(vararg names: String) = createWhereField("name", names)
        val sort = createWhereField("sort")
        @Contract(pure = true)
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        @Contract(pure = true)
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
        val default = createWhereField("default")
        @Contract(pure = true)
        fun default(defaultList: List<Boolean>) = createWhereField("default", defaultList.toTypedArray())
        @Contract(pure = true)
        fun default(vararg defaults: Boolean) = createWhereField("default", defaults.toTypedArray())
        val public = createWhereField("public")
        @Contract(pure = true)
        fun public(publicList: List<Boolean>) = createWhereField("public", publicList.toTypedArray())
        @Contract(pure = true)
        fun public(vararg publics: Boolean) = createWhereField("public", publics.toTypedArray())
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
        fun sysUserId() = createOrderByField("sys_user_id")
        @Contract(pure = true)
        fun sysQueryId() = createOrderByField("sys_query_id")
        @Contract(pure = true)
        fun sysQueryTagCnRedundant() = createOrderByField("sys_query_tag_cn_redundant")
        @Contract(pure = true)
        fun name() = createOrderByField("name")
        @Contract(pure = true)
        fun sort() = createOrderByField("sort")
        @Contract(pure = true)
        fun default() = createOrderByField("default")
        @Contract(pure = true)
        fun public() = createOrderByField("public")
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
        fun sysUserId() = getColumn(createField("sys_user_id"), Long::class.java)
        fun sysQueryId() = getColumn(createField("sys_query_id"), Long::class.java)
        fun sysQueryTagCnRedundant() = getColumn(createField("sys_query_tag_cn_redundant"), String::class.java)
        fun name() = getColumn(createField("name"), String::class.java)
        fun sort() = getColumn(createField("sort"), Int::class.java)
        fun default() = getColumn(createField("default"), Boolean::class.java)
        fun public() = getColumn(createField("public"), Boolean::class.java)
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
        fun sysUserId() = createColumnsLimiterField("sys_user_id")
        @Contract(pure = true)
        fun sysQueryId() = createColumnsLimiterField("sys_query_id")
        @Contract(pure = true)
        fun sysQueryTagCnRedundant() = createColumnsLimiterField("sys_query_tag_cn_redundant")
        @Contract(pure = true)
        fun name() = createColumnsLimiterField("name")
        @Contract(pure = true)
        fun sort() = createColumnsLimiterField("sort")
        @Contract(pure = true)
        fun default() = createColumnsLimiterField("default")
        @Contract(pure = true)
        fun public() = createColumnsLimiterField("public")
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
        fun sysUserId(sysUserId: Any) = createUpdateSetField("sys_user_id", sysUserId)
        @Contract(pure = true)
        fun sysQueryId(sysQueryId: Any) = createUpdateSetField("sys_query_id", sysQueryId)
        @Contract(pure = true)
        fun sysQueryTagCnRedundant(sysQueryTagCnRedundant: Any) = createUpdateSetField("sys_query_tag_cn_redundant", sysQueryTagCnRedundant)
        @Contract(pure = true)
        fun name(name: Any) = createUpdateSetField("name", name)
        @Contract(pure = true)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
        @Contract(pure = true)
        fun default(default: Any) = createUpdateSetField("default", default)
        @Contract(pure = true)
        fun public(public: Any) = createUpdateSetField("public", public)
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
        fun sysUserId() = this.also { fields.add(createField("sys_user_id")) }
        fun sysQueryId() = this.also { fields.add(createField("sys_query_id")) }
        fun sysQueryTagCnRedundant() = this.also { fields.add(createField("sys_query_tag_cn_redundant")) }
        fun name() = this.also { fields.add(createField("name")) }
        fun sort() = this.also { fields.add(createField("sort")) }
        fun default() = this.also { fields.add(createField("default")) }
        fun public() = this.also { fields.add(createField("public")) }
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
            SysQueryUserPlanEntity,
            Long,
            ImplSysQueryUserPlanQueryPro.WhereField<SysQueryUserPlanEntity, List<SysQueryUserPlanEntity>>,
            ImplSysQueryUserPlanQueryPro.OrderByField<SysQueryUserPlanEntity, List<SysQueryUserPlanEntity>>,
            ImplSysQueryUserPlanQueryPro.UpdateSetField,
            ImplSysQueryUserPlanQueryPro.WhereField<Boolean, Boolean>,
            ImplSysQueryUserPlanQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysQueryUserPlanEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysQueryUserPlanQueryPro.WhereField(qs, SysQueryUserPlanEntity::class.java) },
        { qs: QueryStructure -> ImplSysQueryUserPlanQueryPro.OrderByField(qs, SysQueryUserPlanEntity::class.java) },
        { qs: QueryStructure -> ImplSysQueryUserPlanQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysQueryUserPlanQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysQueryUserPlanQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysQueryUserPlanQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysQueryUserPlanQueryPro.TABLE_NAME)))

val SysQueryUserPlanQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysQueryUserPlanQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysQueryUserPlanQueryPro.WhereField<SysQueryUserPlanEntity, List<SysQueryUserPlanEntity>>(qs, SysQueryUserPlanEntity::class.java) },
    { ImplSysQueryUserPlanQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
