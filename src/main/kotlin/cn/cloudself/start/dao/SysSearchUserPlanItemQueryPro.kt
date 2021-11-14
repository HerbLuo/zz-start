@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSearchUserPlanItemEntity
import java.util.Date
import cn.cloudself.query.*

class ImplSysSearchUserPlanItemQueryPro {
    companion object {
        const val TABLE_NAME = "sys_search_user_plan_item"
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
        val sysUserId = createWhereField("sys_user_id")
        fun sysUserId(sysUserIdList: List<Long>) = createWhereField("sys_user_id", sysUserIdList.toTypedArray())
        fun sysUserId(vararg sysUserIds: Long) = createWhereField("sys_user_id", sysUserIds.toTypedArray())
        val sysSearchConfigId = createWhereField("sys_search_config_id")
        fun sysSearchConfigId(sysSearchConfigIdList: List<Long>) = createWhereField("sys_search_config_id", sysSearchConfigIdList.toTypedArray())
        fun sysSearchConfigId(vararg sysSearchConfigIds: Long) = createWhereField("sys_search_config_id", sysSearchConfigIds.toTypedArray())
        val sysSearchConfigColumnId = createWhereField("sys_search_config_column_id")
        fun sysSearchConfigColumnId(sysSearchConfigColumnIdList: List<Long>) = createWhereField("sys_search_config_column_id", sysSearchConfigColumnIdList.toTypedArray())
        fun sysSearchConfigColumnId(vararg sysSearchConfigColumnIds: Long) = createWhereField("sys_search_config_column_id", sysSearchConfigColumnIds.toTypedArray())
        val searchCondition = createWhereField("search_condition")
        fun searchCondition(searchConditionList: List<String>) = createWhereField("search_condition", searchConditionList.toTypedArray())
        fun searchCondition(vararg searchConditions: String) = createWhereField("search_condition", searchConditions)
        val searchValue = createWhereField("search_value")
        fun searchValue(searchValueList: List<String>) = createWhereField("search_value", searchValueList.toTypedArray())
        fun searchValue(vararg searchValues: String) = createWhereField("search_value", searchValues)
        val sort = createWhereField("sort")
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
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
        fun sysUserId() = createOrderByField("sys_user_id")
        fun sysSearchConfigId() = createOrderByField("sys_search_config_id")
        fun sysSearchConfigColumnId() = createOrderByField("sys_search_config_column_id")
        fun searchCondition() = createOrderByField("search_condition")
        fun searchValue() = createOrderByField("search_value")
        fun sort() = createOrderByField("sort")
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
        fun sysUserId() = getColumn(createField("sys_user_id"), Long::class.java)
        fun sysSearchConfigId() = getColumn(createField("sys_search_config_id"), Long::class.java)
        fun sysSearchConfigColumnId() = getColumn(createField("sys_search_config_column_id"), Long::class.java)
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

        fun id() = createColumnsLimiterField("id")
        fun sysUserId() = createColumnsLimiterField("sys_user_id")
        fun sysSearchConfigId() = createColumnsLimiterField("sys_search_config_id")
        fun sysSearchConfigColumnId() = createColumnsLimiterField("sys_search_config_column_id")
        fun searchCondition() = createColumnsLimiterField("search_condition")
        fun searchValue() = createColumnsLimiterField("search_value")
        fun sort() = createColumnsLimiterField("sort")
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
        fun sysUserId(sysUserId: Any) = createUpdateSetField("sys_user_id", sysUserId)
        fun sysSearchConfigId(sysSearchConfigId: Any) = createUpdateSetField("sys_search_config_id", sysSearchConfigId)
        fun sysSearchConfigColumnId(sysSearchConfigColumnId: Any) = createUpdateSetField("sys_search_config_column_id", sysSearchConfigColumnId)
        fun searchCondition(searchCondition: Any) = createUpdateSetField("search_condition", searchCondition)
        fun searchValue(searchValue: Any) = createUpdateSetField("search_value", searchValue)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
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
        fun sysUserId() = this.also { fields.add(createField("sys_user_id")) }
        fun sysSearchConfigId() = this.also { fields.add(createField("sys_search_config_id")) }
        fun sysSearchConfigColumnId() = this.also { fields.add(createField("sys_search_config_column_id")) }
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
            SysSearchUserPlanItemEntity,
            Long,
            ImplSysSearchUserPlanItemQueryPro.WhereField<SysSearchUserPlanItemEntity, List<SysSearchUserPlanItemEntity>>,
            ImplSysSearchUserPlanItemQueryPro.OrderByField<SysSearchUserPlanItemEntity, List<SysSearchUserPlanItemEntity>>,
            ImplSysSearchUserPlanItemQueryPro.UpdateSetField,
            ImplSysSearchUserPlanItemQueryPro.WhereField<Boolean, Boolean>,
            ImplSysSearchUserPlanItemQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysSearchUserPlanItemEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysSearchUserPlanItemQueryPro.WhereField(qs, SysSearchUserPlanItemEntity::class.java) },
        { qs: QueryStructure -> ImplSysSearchUserPlanItemQueryPro.OrderByField(qs, SysSearchUserPlanItemEntity::class.java) },
        { qs: QueryStructure -> ImplSysSearchUserPlanItemQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysSearchUserPlanItemQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysSearchUserPlanItemQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysSearchUserPlanItemQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysSearchUserPlanItemQueryPro.TABLE_NAME)))

val SysSearchUserPlanItemQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysSearchUserPlanItemQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysSearchUserPlanItemQueryPro.WhereField<SysSearchUserPlanItemEntity, List<SysSearchUserPlanItemEntity>>(qs, SysSearchUserPlanItemEntity::class.java) },
    { ImplSysSearchUserPlanItemQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
