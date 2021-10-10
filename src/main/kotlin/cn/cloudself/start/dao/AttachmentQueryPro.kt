@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.AttachmentEntity
import java.util.Date
import cn.cloudself.query.*

class ImplAttachmentQueryPro {
    companion object {
        const val TABLE_NAME = "attachment"
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

        val id = createWhereField("id")
        val business = createWhereField("business")
        val businessId = createWhereField("business_id")
        val hash = createWhereField("hash")
        val name = createWhereField("name")
        val size = createWhereField("size")
        val status = createWhereField("status")
        val createBy = createWhereField("create_by")
        val createTime = createWhereField("create_time")
        val updateBy = createWhereField("update_by")
        val updateTime = createWhereField("update_time")
        val deleted = createWhereField("deleted")
        val remark = createWhereField("remark")
    }

    class OrderByField<T, RUN_RES> constructor(queryStructure: QueryStructure, field_clazz: Class<T>): CommonField<T, RUN_RES>(queryStructure, field_clazz) {
        override val field_type = QueryFieldType.ORDER_BY_FIELD

        private fun createOrderByField(column: String) =
            QueryOrderByKeywords(createField(column), queryStructure, create_order_by_field)

        fun id() = createOrderByField("id")
        fun business() = createOrderByField("business")
        fun businessId() = createOrderByField("business_id")
        fun hash() = createOrderByField("hash")
        fun name() = createOrderByField("name")
        fun size() = createOrderByField("size")
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
        fun business() = getColumn(createField("business"), String::class.java)
        fun businessId() = getColumn(createField("business_id"), Long::class.java)
        fun hash() = getColumn(createField("hash"), String::class.java)
        fun name() = getColumn(createField("name"), String::class.java)
        fun size() = getColumn(createField("size"), Long::class.java)
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
        fun business() = createColumnsLimiterField("business")
        fun businessId() = createColumnsLimiterField("business_id")
        fun hash() = createColumnsLimiterField("hash")
        fun name() = createColumnsLimiterField("name")
        fun size() = createColumnsLimiterField("size")
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
        fun business(business: Any) = createUpdateSetField("business", business)
        fun businessId(businessId: Any) = createUpdateSetField("business_id", businessId)
        fun hash(hash: Any) = createUpdateSetField("hash", hash)
        fun name(name: Any) = createUpdateSetField("name", name)
        fun size(size: Any) = createUpdateSetField("size", size)
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
        fun business() = this.also { fields.add(createField("business")) }
        fun businessId() = this.also { fields.add(createField("business_id")) }
        fun hash() = this.also { fields.add(createField("hash")) }
        fun name() = this.also { fields.add(createField("name")) }
        fun size() = this.also { fields.add(createField("size")) }
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
            AttachmentEntity,
            Long,
            ImplAttachmentQueryPro.WhereField<AttachmentEntity, List<AttachmentEntity>>,
            ImplAttachmentQueryPro.OrderByField<AttachmentEntity, List<AttachmentEntity>>,
            ImplAttachmentQueryPro.UpdateSetField,
            ImplAttachmentQueryPro.WhereField<Boolean, Boolean>,
            ImplAttachmentQueryPro.WhereField<Boolean, Boolean>,
    > (
        AttachmentEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplAttachmentQueryPro.WhereField(qs, AttachmentEntity::class.java) },
        { qs: QueryStructure -> ImplAttachmentQueryPro.OrderByField(qs, AttachmentEntity::class.java) },
        { qs: QueryStructure -> ImplAttachmentQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplAttachmentQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplAttachmentQueryPro.WhereField(qs, Boolean::class.java) },
    )

val AttachmentQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplAttachmentQueryPro.TABLE_NAME)))

val AttachmentQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplAttachmentQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplAttachmentQueryPro.WhereField<AttachmentEntity, List<AttachmentEntity>>(qs, AttachmentEntity::class.java) },
    { ImplAttachmentQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
