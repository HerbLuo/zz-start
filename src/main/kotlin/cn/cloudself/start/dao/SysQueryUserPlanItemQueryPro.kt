@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysQueryUserPlanItemEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


class ImplSysQueryUserPlanItemQueryPro {
    companion object {
        const val TABLE_NAME = "sys_query_user_plan_item"
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
        override fun getPayload() = SysQueryUserPlanItemQueryPro.payload
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
        val sysQueryId = createWhereField("sys_query_id")
        @Contract(pure = true)
        fun sysQueryId(sysQueryIdList: List<Long>) = createWhereField("sys_query_id", sysQueryIdList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryId(vararg sysQueryIds: Long) = createWhereField("sys_query_id", sysQueryIds.toTypedArray())
        val sysQueryUserPlanId = createWhereField("sys_query_user_plan_id")
        @Contract(pure = true)
        fun sysQueryUserPlanId(sysQueryUserPlanIdList: List<Long>) = createWhereField("sys_query_user_plan_id", sysQueryUserPlanIdList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryUserPlanId(vararg sysQueryUserPlanIds: Long) = createWhereField("sys_query_user_plan_id", sysQueryUserPlanIds.toTypedArray())
        val sysQueryElementId = createWhereField("sys_query_element_id")
        @Contract(pure = true)
        fun sysQueryElementId(sysQueryElementIdList: List<Long>) = createWhereField("sys_query_element_id", sysQueryElementIdList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryElementId(vararg sysQueryElementIds: Long) = createWhereField("sys_query_element_id", sysQueryElementIds.toTypedArray())
        val sysUserIdRedundant = createWhereField("sys_user_id_redundant")
        @Contract(pure = true)
        fun sysUserIdRedundant(sysUserIdRedundantList: List<Long>) = createWhereField("sys_user_id_redundant", sysUserIdRedundantList.toTypedArray())
        @Contract(pure = true)
        fun sysUserIdRedundant(vararg sysUserIdRedundants: Long) = createWhereField("sys_user_id_redundant", sysUserIdRedundants.toTypedArray())
        val sysQueryTagCnRedundant = createWhereField("sys_query_tag_cn_redundant")
        @Contract(pure = true)
        fun sysQueryTagCnRedundant(sysQueryTagCnRedundantList: List<String>) = createWhereField("sys_query_tag_cn_redundant", sysQueryTagCnRedundantList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryTagCnRedundant(vararg sysQueryTagCnRedundants: String) = createWhereField("sys_query_tag_cn_redundant", sysQueryTagCnRedundants)
        val sysQueryElementAliasCnRedundant = createWhereField("sys_query_element_alias_cn_redundant")
        @Contract(pure = true)
        fun sysQueryElementAliasCnRedundant(sysQueryElementAliasCnRedundantList: List<String>) = createWhereField("sys_query_element_alias_cn_redundant", sysQueryElementAliasCnRedundantList.toTypedArray())
        @Contract(pure = true)
        fun sysQueryElementAliasCnRedundant(vararg sysQueryElementAliasCnRedundants: String) = createWhereField("sys_query_element_alias_cn_redundant", sysQueryElementAliasCnRedundants)
        val searchCondition = createWhereField("search_condition")
        @Contract(pure = true)
        fun searchCondition(searchConditionList: List<String>) = createWhereField("search_condition", searchConditionList.toTypedArray())
        @Contract(pure = true)
        fun searchCondition(vararg searchConditions: String) = createWhereField("search_condition", searchConditions)
        val searchValue = createWhereField("search_value")
        @Contract(pure = true)
        fun searchValue(searchValueList: List<String>) = createWhereField("search_value", searchValueList.toTypedArray())
        @Contract(pure = true)
        fun searchValue(vararg searchValues: String) = createWhereField("search_value", searchValues)
        val sort = createWhereField("sort")
        @Contract(pure = true)
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        @Contract(pure = true)
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
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
        fun sysQueryId() = createOrderByField("sys_query_id")
        @Contract(pure = true)
        fun sysQueryUserPlanId() = createOrderByField("sys_query_user_plan_id")
        @Contract(pure = true)
        fun sysQueryElementId() = createOrderByField("sys_query_element_id")
        @Contract(pure = true)
        fun sysUserIdRedundant() = createOrderByField("sys_user_id_redundant")
        @Contract(pure = true)
        fun sysQueryTagCnRedundant() = createOrderByField("sys_query_tag_cn_redundant")
        @Contract(pure = true)
        fun sysQueryElementAliasCnRedundant() = createOrderByField("sys_query_element_alias_cn_redundant")
        @Contract(pure = true)
        fun searchCondition() = createOrderByField("search_condition")
        @Contract(pure = true)
        fun searchValue() = createOrderByField("search_value")
        @Contract(pure = true)
        fun sort() = createOrderByField("sort")
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
        fun sysQueryId() = getColumn(createField("sys_query_id"), Long::class.java)
        fun sysQueryUserPlanId() = getColumn(createField("sys_query_user_plan_id"), Long::class.java)
        fun sysQueryElementId() = getColumn(createField("sys_query_element_id"), Long::class.java)
        fun sysUserIdRedundant() = getColumn(createField("sys_user_id_redundant"), Long::class.java)
        fun sysQueryTagCnRedundant() = getColumn(createField("sys_query_tag_cn_redundant"), String::class.java)
        fun sysQueryElementAliasCnRedundant() = getColumn(createField("sys_query_element_alias_cn_redundant"), String::class.java)
        fun searchCondition() = getColumn(createField("search_condition"), String::class.java)
        fun searchValue() = getColumn(createField("search_value"), String::class.java)
        fun sort() = getColumn(createField("sort"), Int::class.java)
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
        fun sysQueryId() = createColumnsLimiterField("sys_query_id")
        @Contract(pure = true)
        fun sysQueryUserPlanId() = createColumnsLimiterField("sys_query_user_plan_id")
        @Contract(pure = true)
        fun sysQueryElementId() = createColumnsLimiterField("sys_query_element_id")
        @Contract(pure = true)
        fun sysUserIdRedundant() = createColumnsLimiterField("sys_user_id_redundant")
        @Contract(pure = true)
        fun sysQueryTagCnRedundant() = createColumnsLimiterField("sys_query_tag_cn_redundant")
        @Contract(pure = true)
        fun sysQueryElementAliasCnRedundant() = createColumnsLimiterField("sys_query_element_alias_cn_redundant")
        @Contract(pure = true)
        fun searchCondition() = createColumnsLimiterField("search_condition")
        @Contract(pure = true)
        fun searchValue() = createColumnsLimiterField("search_value")
        @Contract(pure = true)
        fun sort() = createColumnsLimiterField("sort")
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
        fun sysQueryId(sysQueryId: Any) = createUpdateSetField("sys_query_id", sysQueryId)
        @Contract(pure = true)
        fun sysQueryUserPlanId(sysQueryUserPlanId: Any) = createUpdateSetField("sys_query_user_plan_id", sysQueryUserPlanId)
        @Contract(pure = true)
        fun sysQueryElementId(sysQueryElementId: Any) = createUpdateSetField("sys_query_element_id", sysQueryElementId)
        @Contract(pure = true)
        fun sysUserIdRedundant(sysUserIdRedundant: Any) = createUpdateSetField("sys_user_id_redundant", sysUserIdRedundant)
        @Contract(pure = true)
        fun sysQueryTagCnRedundant(sysQueryTagCnRedundant: Any) = createUpdateSetField("sys_query_tag_cn_redundant", sysQueryTagCnRedundant)
        @Contract(pure = true)
        fun sysQueryElementAliasCnRedundant(sysQueryElementAliasCnRedundant: Any) = createUpdateSetField("sys_query_element_alias_cn_redundant", sysQueryElementAliasCnRedundant)
        @Contract(pure = true)
        fun searchCondition(searchCondition: Any) = createUpdateSetField("search_condition", searchCondition)
        @Contract(pure = true)
        fun searchValue(searchValue: Any) = createUpdateSetField("search_value", searchValue)
        @Contract(pure = true)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
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
        fun sysQueryId() = this.also { fields.add(createField("sys_query_id")) }
        fun sysQueryUserPlanId() = this.also { fields.add(createField("sys_query_user_plan_id")) }
        fun sysQueryElementId() = this.also { fields.add(createField("sys_query_element_id")) }
        fun sysUserIdRedundant() = this.also { fields.add(createField("sys_user_id_redundant")) }
        fun sysQueryTagCnRedundant() = this.also { fields.add(createField("sys_query_tag_cn_redundant")) }
        fun sysQueryElementAliasCnRedundant() = this.also { fields.add(createField("sys_query_element_alias_cn_redundant")) }
        fun searchCondition() = this.also { fields.add(createField("search_condition")) }
        fun searchValue() = this.also { fields.add(createField("search_value")) }
        fun sort() = this.also { fields.add(createField("sort")) }
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
            SysQueryUserPlanItemEntity,
            Long,
            ImplSysQueryUserPlanItemQueryPro.WhereField<SysQueryUserPlanItemEntity, List<SysQueryUserPlanItemEntity>>,
            ImplSysQueryUserPlanItemQueryPro.OrderByField<SysQueryUserPlanItemEntity, List<SysQueryUserPlanItemEntity>>,
            ImplSysQueryUserPlanItemQueryPro.UpdateSetField,
            ImplSysQueryUserPlanItemQueryPro.WhereField<Boolean, Boolean>,
            ImplSysQueryUserPlanItemQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysQueryUserPlanItemEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysQueryUserPlanItemQueryPro.WhereField(qs, SysQueryUserPlanItemEntity::class.java) },
        { qs: QueryStructure -> ImplSysQueryUserPlanItemQueryPro.OrderByField(qs, SysQueryUserPlanItemEntity::class.java) },
        { qs: QueryStructure -> ImplSysQueryUserPlanItemQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysQueryUserPlanItemQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysQueryUserPlanItemQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysQueryUserPlanItemQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysQueryUserPlanItemQueryPro.TABLE_NAME)))

val SysQueryUserPlanItemQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysQueryUserPlanItemQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysQueryUserPlanItemQueryPro.WhereField<SysQueryUserPlanItemEntity, List<SysQueryUserPlanItemEntity>>(qs, SysQueryUserPlanItemEntity::class.java) },
    { ImplSysQueryUserPlanItemQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
