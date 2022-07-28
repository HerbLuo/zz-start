@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSpEleEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


class ImplSysSpEleQueryPro {
    companion object {
        const val TABLE_NAME = "sys_sp_ele"
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
        override fun getPayload() = SysSpEleQueryPro.payload
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
        val sysSpId = createWhereField("sys_sp_id")
        @Contract(pure = true)
        fun sysSpId(sysSpIdList: List<Long>) = createWhereField("sys_sp_id", sysSpIdList.toTypedArray())
        @Contract(pure = true)
        fun sysSpId(vararg sysSpIds: Long) = createWhereField("sys_sp_id", sysSpIds.toTypedArray())
        val tagCn = createWhereField("tag_cn")
        @Contract(pure = true)
        fun tagCn(tagCnList: List<String>) = createWhereField("tag_cn", tagCnList.toTypedArray())
        @Contract(pure = true)
        fun tagCn(vararg tagCns: String) = createWhereField("tag_cn", tagCns)
        val alias = createWhereField("alias")
        @Contract(pure = true)
        fun alias(aliasList: List<String>) = createWhereField("alias", aliasList.toTypedArray())
        @Contract(pure = true)
        fun alias(vararg aliass: String) = createWhereField("alias", aliass)
        val aliasCn = createWhereField("alias_cn")
        @Contract(pure = true)
        fun aliasCn(aliasCnList: List<String>) = createWhereField("alias_cn", aliasCnList.toTypedArray())
        @Contract(pure = true)
        fun aliasCn(vararg aliasCns: String) = createWhereField("alias_cn", aliasCns)
        val sqlColumn = createWhereField("sql")
        @Contract(pure = true)
        fun sqlColumn(sqlColumnList: List<String>) = createWhereField("sql", sqlColumnList.toTypedArray())
        @Contract(pure = true)
        fun sqlColumn(vararg sqlColumns: String) = createWhereField("sql", sqlColumns)
        val limitConditions = createWhereField("limit_conditions")
        @Contract(pure = true)
        fun limitConditions(limitConditionsList: List<String>) = createWhereField("limit_conditions", limitConditionsList.toTypedArray())
        @Contract(pure = true)
        fun limitConditions(vararg limitConditionss: String) = createWhereField("limit_conditions", limitConditionss)
        val limitType = createWhereField("limit_type")
        @Contract(pure = true)
        fun limitType(limitTypeList: List<String>) = createWhereField("limit_type", limitTypeList.toTypedArray())
        @Contract(pure = true)
        fun limitType(vararg limitTypes: String) = createWhereField("limit_type", limitTypes)
        val limitValues = createWhereField("limit_values")
        @Contract(pure = true)
        fun limitValues(limitValuesList: List<String>) = createWhereField("limit_values", limitValuesList.toTypedArray())
        @Contract(pure = true)
        fun limitValues(vararg limitValuess: String) = createWhereField("limit_values", limitValuess)
        val type = createWhereField("type")
        @Contract(pure = true)
        fun type(typeList: List<String>) = createWhereField("type", typeList.toTypedArray())
        @Contract(pure = true)
        fun type(vararg types: String) = createWhereField("type", types)
        val hidden = createWhereField("hidden")
        @Contract(pure = true)
        fun hidden(hiddenList: List<Boolean>) = createWhereField("hidden", hiddenList.toTypedArray())
        @Contract(pure = true)
        fun hidden(vararg hiddens: Boolean) = createWhereField("hidden", hiddens.toTypedArray())
        val sort = createWhereField("sort")
        @Contract(pure = true)
        fun sort(sortList: List<Int>) = createWhereField("sort", sortList.toTypedArray())
        @Contract(pure = true)
        fun sort(vararg sorts: Int) = createWhereField("sort", sorts.toTypedArray())
        val fixed = createWhereField("fixed")
        @Contract(pure = true)
        fun fixed(fixedList: List<String>) = createWhereField("fixed", fixedList.toTypedArray())
        @Contract(pure = true)
        fun fixed(vararg fixeds: String) = createWhereField("fixed", fixeds)
        val orderByColumn = createWhereField("order_by")
        @Contract(pure = true)
        fun orderByColumn(orderByColumnList: List<String>) = createWhereField("order_by", orderByColumnList.toTypedArray())
        @Contract(pure = true)
        fun orderByColumn(vararg orderByColumns: String) = createWhereField("order_by", orderByColumns)
        val orderByIndex = createWhereField("order_by_index")
        @Contract(pure = true)
        fun orderByIndex(orderByIndexList: List<Int>) = createWhereField("order_by_index", orderByIndexList.toTypedArray())
        @Contract(pure = true)
        fun orderByIndex(vararg orderByIndexs: Int) = createWhereField("order_by_index", orderByIndexs.toTypedArray())
        val width = createWhereField("width")
        @Contract(pure = true)
        fun width(widthList: List<String>) = createWhereField("width", widthList.toTypedArray())
        @Contract(pure = true)
        fun width(vararg widths: String) = createWhereField("width", widths)
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
        fun sysSpId() = createOrderByField("sys_sp_id")
        @Contract(pure = true)
        fun tagCn() = createOrderByField("tag_cn")
        @Contract(pure = true)
        fun alias() = createOrderByField("alias")
        @Contract(pure = true)
        fun aliasCn() = createOrderByField("alias_cn")
        @Contract(pure = true)
        fun sqlColumn() = createOrderByField("sql")
        @Contract(pure = true)
        fun limitConditions() = createOrderByField("limit_conditions")
        @Contract(pure = true)
        fun limitType() = createOrderByField("limit_type")
        @Contract(pure = true)
        fun limitValues() = createOrderByField("limit_values")
        @Contract(pure = true)
        fun type() = createOrderByField("type")
        @Contract(pure = true)
        fun hidden() = createOrderByField("hidden")
        @Contract(pure = true)
        fun sort() = createOrderByField("sort")
        @Contract(pure = true)
        fun fixed() = createOrderByField("fixed")
        @Contract(pure = true)
        fun orderByColumn() = createOrderByField("order_by")
        @Contract(pure = true)
        fun orderByIndex() = createOrderByField("order_by_index")
        @Contract(pure = true)
        fun width() = createOrderByField("width")
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
        fun sysSpId() = getColumn(createField("sys_sp_id"), Long::class.java)
        fun tagCn() = getColumn(createField("tag_cn"), String::class.java)
        fun alias() = getColumn(createField("alias"), String::class.java)
        fun aliasCn() = getColumn(createField("alias_cn"), String::class.java)
        fun sqlColumn() = getColumn(createField("sql"), String::class.java)
        fun limitConditions() = getColumn(createField("limit_conditions"), String::class.java)
        fun limitType() = getColumn(createField("limit_type"), String::class.java)
        fun limitValues() = getColumn(createField("limit_values"), String::class.java)
        fun type() = getColumn(createField("type"), String::class.java)
        fun hidden() = getColumn(createField("hidden"), Boolean::class.java)
        fun sort() = getColumn(createField("sort"), Int::class.java)
        fun fixed() = getColumn(createField("fixed"), String::class.java)
        fun orderByColumn() = getColumn(createField("order_by"), String::class.java)
        fun orderByIndex() = getColumn(createField("order_by_index"), Int::class.java)
        fun width() = getColumn(createField("width"), String::class.java)
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
        fun sysSpId() = createColumnsLimiterField("sys_sp_id")
        @Contract(pure = true)
        fun tagCn() = createColumnsLimiterField("tag_cn")
        @Contract(pure = true)
        fun alias() = createColumnsLimiterField("alias")
        @Contract(pure = true)
        fun aliasCn() = createColumnsLimiterField("alias_cn")
        @Contract(pure = true)
        fun sqlColumn() = createColumnsLimiterField("sql")
        @Contract(pure = true)
        fun limitConditions() = createColumnsLimiterField("limit_conditions")
        @Contract(pure = true)
        fun limitType() = createColumnsLimiterField("limit_type")
        @Contract(pure = true)
        fun limitValues() = createColumnsLimiterField("limit_values")
        @Contract(pure = true)
        fun type() = createColumnsLimiterField("type")
        @Contract(pure = true)
        fun hidden() = createColumnsLimiterField("hidden")
        @Contract(pure = true)
        fun sort() = createColumnsLimiterField("sort")
        @Contract(pure = true)
        fun fixed() = createColumnsLimiterField("fixed")
        @Contract(pure = true)
        fun orderByColumn() = createColumnsLimiterField("order_by")
        @Contract(pure = true)
        fun orderByIndex() = createColumnsLimiterField("order_by_index")
        @Contract(pure = true)
        fun width() = createColumnsLimiterField("width")
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
        fun sysSpId(sysSpId: Any) = createUpdateSetField("sys_sp_id", sysSpId)
        @Contract(pure = true)
        fun tagCn(tagCn: Any) = createUpdateSetField("tag_cn", tagCn)
        @Contract(pure = true)
        fun alias(alias: Any) = createUpdateSetField("alias", alias)
        @Contract(pure = true)
        fun aliasCn(aliasCn: Any) = createUpdateSetField("alias_cn", aliasCn)
        @Contract(pure = true)
        fun sqlColumn(sqlColumn: Any) = createUpdateSetField("sql", sqlColumn)
        @Contract(pure = true)
        fun limitConditions(limitConditions: Any) = createUpdateSetField("limit_conditions", limitConditions)
        @Contract(pure = true)
        fun limitType(limitType: Any) = createUpdateSetField("limit_type", limitType)
        @Contract(pure = true)
        fun limitValues(limitValues: Any) = createUpdateSetField("limit_values", limitValues)
        @Contract(pure = true)
        fun type(type: Any) = createUpdateSetField("type", type)
        @Contract(pure = true)
        fun hidden(hidden: Any) = createUpdateSetField("hidden", hidden)
        @Contract(pure = true)
        fun sort(sort: Any) = createUpdateSetField("sort", sort)
        @Contract(pure = true)
        fun fixed(fixed: Any) = createUpdateSetField("fixed", fixed)
        @Contract(pure = true)
        fun orderByColumn(orderByColumn: Any) = createUpdateSetField("order_by", orderByColumn)
        @Contract(pure = true)
        fun orderByIndex(orderByIndex: Any) = createUpdateSetField("order_by_index", orderByIndex)
        @Contract(pure = true)
        fun width(width: Any) = createUpdateSetField("width", width)
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
        fun sysSpId() = this.also { fields.add(createField("sys_sp_id")) }
        fun tagCn() = this.also { fields.add(createField("tag_cn")) }
        fun alias() = this.also { fields.add(createField("alias")) }
        fun aliasCn() = this.also { fields.add(createField("alias_cn")) }
        fun sqlColumn() = this.also { fields.add(createField("sql")) }
        fun limitConditions() = this.also { fields.add(createField("limit_conditions")) }
        fun limitType() = this.also { fields.add(createField("limit_type")) }
        fun limitValues() = this.also { fields.add(createField("limit_values")) }
        fun type() = this.also { fields.add(createField("type")) }
        fun hidden() = this.also { fields.add(createField("hidden")) }
        fun sort() = this.also { fields.add(createField("sort")) }
        fun fixed() = this.also { fields.add(createField("fixed")) }
        fun orderByColumn() = this.also { fields.add(createField("order_by")) }
        fun orderByIndex() = this.also { fields.add(createField("order_by_index")) }
        fun width() = this.also { fields.add(createField("width")) }
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
            SysSpEleEntity,
            Long,
            ImplSysSpEleQueryPro.WhereField<SysSpEleEntity, List<SysSpEleEntity>>,
            ImplSysSpEleQueryPro.OrderByField<SysSpEleEntity, List<SysSpEleEntity>>,
            ImplSysSpEleQueryPro.UpdateSetField,
            ImplSysSpEleQueryPro.WhereField<Boolean, Boolean>,
            ImplSysSpEleQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysSpEleEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysSpEleQueryPro.WhereField(qs, SysSpEleEntity::class.java) },
        { qs: QueryStructure -> ImplSysSpEleQueryPro.OrderByField(qs, SysSpEleEntity::class.java) },
        { qs: QueryStructure -> ImplSysSpEleQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysSpEleQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysSpEleQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysSpEleQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysSpEleQueryPro.TABLE_NAME)))

val SysSpEleQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysSpEleQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysSpEleQueryPro.WhereField<SysSpEleEntity, List<SysSpEleEntity>>(qs, SysSpEleEntity::class.java) },
    { ImplSysSpEleQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
