@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysSelectUserTableColumnEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


class ImplSysSelectUserTableColumnQueryPro {
    companion object {
        const val TABLE_NAME = "sys_select_user_table_column"
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
        override fun getPayload() = SysSelectUserTableColumnQueryPro.payload
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
        val pageTag = createWhereField("page_tag")
        @Contract(pure = true)
        fun pageTag(pageTagList: List<String>) = createWhereField("page_tag", pageTagList.toTypedArray())
        @Contract(pure = true)
        fun pageTag(vararg pageTags: String) = createWhereField("page_tag", pageTags)
        val sysUserId = createWhereField("sys_user_id")
        @Contract(pure = true)
        fun sysUserId(sysUserIdList: List<Long>) = createWhereField("sys_user_id", sysUserIdList.toTypedArray())
        @Contract(pure = true)
        fun sysUserId(vararg sysUserIds: Long) = createWhereField("sys_user_id", sysUserIds.toTypedArray())
        val sysSelectElementId = createWhereField("sys_select_element_id")
        @Contract(pure = true)
        fun sysSelectElementId(sysSelectElementIdList: List<Long>) = createWhereField("sys_select_element_id", sysSelectElementIdList.toTypedArray())
        @Contract(pure = true)
        fun sysSelectElementId(vararg sysSelectElementIds: Long) = createWhereField("sys_select_element_id", sysSelectElementIds.toTypedArray())
        val title = createWhereField("title")
        @Contract(pure = true)
        fun title(titleList: List<String>) = createWhereField("title", titleList.toTypedArray())
        @Contract(pure = true)
        fun title(vararg titles: String) = createWhereField("title", titles)
        val dataIndex = createWhereField("data_index")
        @Contract(pure = true)
        fun dataIndex(dataIndexList: List<String>) = createWhereField("data_index", dataIndexList.toTypedArray())
        @Contract(pure = true)
        fun dataIndex(vararg dataIndexs: String) = createWhereField("data_index", dataIndexs)
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
        val css = createWhereField("css")
        @Contract(pure = true)
        fun css(cssList: List<String>) = createWhereField("css", cssList.toTypedArray())
        @Contract(pure = true)
        fun css(vararg csss: String) = createWhereField("css", csss)
        val render = createWhereField("render")
        @Contract(pure = true)
        fun render(renderList: List<String>) = createWhereField("render", renderList.toTypedArray())
        @Contract(pure = true)
        fun render(vararg renders: String) = createWhereField("render", renders)
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
        fun pageTag() = createOrderByField("page_tag")
        @Contract(pure = true)
        fun sysUserId() = createOrderByField("sys_user_id")
        @Contract(pure = true)
        fun sysSelectElementId() = createOrderByField("sys_select_element_id")
        @Contract(pure = true)
        fun title() = createOrderByField("title")
        @Contract(pure = true)
        fun dataIndex() = createOrderByField("data_index")
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
        fun css() = createOrderByField("css")
        @Contract(pure = true)
        fun render() = createOrderByField("render")
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
        fun pageTag() = getColumn(createField("page_tag"), String::class.java)
        fun sysUserId() = getColumn(createField("sys_user_id"), Long::class.java)
        fun sysSelectElementId() = getColumn(createField("sys_select_element_id"), Long::class.java)
        fun title() = getColumn(createField("title"), String::class.java)
        fun dataIndex() = getColumn(createField("data_index"), String::class.java)
        fun type() = getColumn(createField("type"), String::class.java)
        fun hidden() = getColumn(createField("hidden"), Boolean::class.java)
        fun sort() = getColumn(createField("sort"), Int::class.java)
        fun fixed() = getColumn(createField("fixed"), String::class.java)
        fun orderByColumn() = getColumn(createField("order_by"), String::class.java)
        fun orderByIndex() = getColumn(createField("order_by_index"), Int::class.java)
        fun width() = getColumn(createField("width"), String::class.java)
        fun css() = getColumn(createField("css"), String::class.java)
        fun render() = getColumn(createField("render"), String::class.java)
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
        fun pageTag() = createColumnsLimiterField("page_tag")
        @Contract(pure = true)
        fun sysUserId() = createColumnsLimiterField("sys_user_id")
        @Contract(pure = true)
        fun sysSelectElementId() = createColumnsLimiterField("sys_select_element_id")
        @Contract(pure = true)
        fun title() = createColumnsLimiterField("title")
        @Contract(pure = true)
        fun dataIndex() = createColumnsLimiterField("data_index")
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
        fun css() = createColumnsLimiterField("css")
        @Contract(pure = true)
        fun render() = createColumnsLimiterField("render")
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
        fun pageTag(pageTag: Any) = createUpdateSetField("page_tag", pageTag)
        @Contract(pure = true)
        fun sysUserId(sysUserId: Any) = createUpdateSetField("sys_user_id", sysUserId)
        @Contract(pure = true)
        fun sysSelectElementId(sysSelectElementId: Any) = createUpdateSetField("sys_select_element_id", sysSelectElementId)
        @Contract(pure = true)
        fun title(title: Any) = createUpdateSetField("title", title)
        @Contract(pure = true)
        fun dataIndex(dataIndex: Any) = createUpdateSetField("data_index", dataIndex)
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
        fun css(css: Any) = createUpdateSetField("css", css)
        @Contract(pure = true)
        fun render(render: Any) = createUpdateSetField("render", render)
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
        fun pageTag() = this.also { fields.add(createField("page_tag")) }
        fun sysUserId() = this.also { fields.add(createField("sys_user_id")) }
        fun sysSelectElementId() = this.also { fields.add(createField("sys_select_element_id")) }
        fun title() = this.also { fields.add(createField("title")) }
        fun dataIndex() = this.also { fields.add(createField("data_index")) }
        fun type() = this.also { fields.add(createField("type")) }
        fun hidden() = this.also { fields.add(createField("hidden")) }
        fun sort() = this.also { fields.add(createField("sort")) }
        fun fixed() = this.also { fields.add(createField("fixed")) }
        fun orderByColumn() = this.also { fields.add(createField("order_by")) }
        fun orderByIndex() = this.also { fields.add(createField("order_by_index")) }
        fun width() = this.also { fields.add(createField("width")) }
        fun css() = this.also { fields.add(createField("css")) }
        fun render() = this.also { fields.add(createField("render")) }
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
            SysSelectUserTableColumnEntity,
            Long,
            ImplSysSelectUserTableColumnQueryPro.WhereField<SysSelectUserTableColumnEntity, List<SysSelectUserTableColumnEntity>>,
            ImplSysSelectUserTableColumnQueryPro.OrderByField<SysSelectUserTableColumnEntity, List<SysSelectUserTableColumnEntity>>,
            ImplSysSelectUserTableColumnQueryPro.UpdateSetField,
            ImplSysSelectUserTableColumnQueryPro.WhereField<Boolean, Boolean>,
            ImplSysSelectUserTableColumnQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysSelectUserTableColumnEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysSelectUserTableColumnQueryPro.WhereField(qs, SysSelectUserTableColumnEntity::class.java) },
        { qs: QueryStructure -> ImplSysSelectUserTableColumnQueryPro.OrderByField(qs, SysSelectUserTableColumnEntity::class.java) },
        { qs: QueryStructure -> ImplSysSelectUserTableColumnQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysSelectUserTableColumnQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysSelectUserTableColumnQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysSelectUserTableColumnQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysSelectUserTableColumnQueryPro.TABLE_NAME)))

val SysSelectUserTableColumnQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysSelectUserTableColumnQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysSelectUserTableColumnQueryPro.WhereField<SysSelectUserTableColumnEntity, List<SysSelectUserTableColumnEntity>>(qs, SysSelectUserTableColumnEntity::class.java) },
    { ImplSysSelectUserTableColumnQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)