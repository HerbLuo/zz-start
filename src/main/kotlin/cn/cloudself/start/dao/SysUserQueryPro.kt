@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysUserEntity
import java.util.Date
import cn.cloudself.query.*

class ImplSysUserQueryPro {
    companion object {
        const val TABLE_NAME = "sys_user"
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
        val userName = createWhereField("user_name")
        val nickName = createWhereField("nick_name")
        val email = createWhereField("email")
        val phone = createWhereField("phone")
        val sex = createWhereField("sex")
        val avatar = createWhereField("avatar")
        val password = createWhereField("password")
        val loginIp = createWhereField("login_ip")
        val loginDate = createWhereField("login_date")
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
        fun userName() = createOrderByField("user_name")
        fun nickName() = createOrderByField("nick_name")
        fun email() = createOrderByField("email")
        fun phone() = createOrderByField("phone")
        fun sex() = createOrderByField("sex")
        fun avatar() = createOrderByField("avatar")
        fun password() = createOrderByField("password")
        fun loginIp() = createOrderByField("login_ip")
        fun loginDate() = createOrderByField("login_date")
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
        fun userName() = getColumn(createField("user_name"), String::class.java)
        fun nickName() = getColumn(createField("nick_name"), String::class.java)
        fun email() = getColumn(createField("email"), String::class.java)
        fun phone() = getColumn(createField("phone"), String::class.java)
        fun sex() = getColumn(createField("sex"), String::class.java)
        fun avatar() = getColumn(createField("avatar"), String::class.java)
        fun password() = getColumn(createField("password"), String::class.java)
        fun loginIp() = getColumn(createField("login_ip"), String::class.java)
        fun loginDate() = getColumn(createField("login_date"), Date::class.java)
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
        fun userName() = createColumnsLimiterField("user_name")
        fun nickName() = createColumnsLimiterField("nick_name")
        fun email() = createColumnsLimiterField("email")
        fun phone() = createColumnsLimiterField("phone")
        fun sex() = createColumnsLimiterField("sex")
        fun avatar() = createColumnsLimiterField("avatar")
        fun password() = createColumnsLimiterField("password")
        fun loginIp() = createColumnsLimiterField("login_ip")
        fun loginDate() = createColumnsLimiterField("login_date")
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
        fun userName(userName: Any) = createUpdateSetField("user_name", userName)
        fun nickName(nickName: Any) = createUpdateSetField("nick_name", nickName)
        fun email(email: Any) = createUpdateSetField("email", email)
        fun phone(phone: Any) = createUpdateSetField("phone", phone)
        fun sex(sex: Any) = createUpdateSetField("sex", sex)
        fun avatar(avatar: Any) = createUpdateSetField("avatar", avatar)
        fun password(password: Any) = createUpdateSetField("password", password)
        fun loginIp(loginIp: Any) = createUpdateSetField("login_ip", loginIp)
        fun loginDate(loginDate: Any) = createUpdateSetField("login_date", loginDate)
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
        fun userName() = this.also { fields.add(createField("user_name")) }
        fun nickName() = this.also { fields.add(createField("nick_name")) }
        fun email() = this.also { fields.add(createField("email")) }
        fun phone() = this.also { fields.add(createField("phone")) }
        fun sex() = this.also { fields.add(createField("sex")) }
        fun avatar() = this.also { fields.add(createField("avatar")) }
        fun password() = this.also { fields.add(createField("password")) }
        fun loginIp() = this.also { fields.add(createField("login_ip")) }
        fun loginDate() = this.also { fields.add(createField("login_date")) }
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
            SysUserEntity,
            Long,
            ImplSysUserQueryPro.WhereField<SysUserEntity, List<SysUserEntity>>,
            ImplSysUserQueryPro.OrderByField<SysUserEntity, List<SysUserEntity>>,
            ImplSysUserQueryPro.UpdateSetField,
            ImplSysUserQueryPro.WhereField<Boolean, Boolean>,
            ImplSysUserQueryPro.WhereField<Boolean, Boolean>,
    > (
        SysUserEntity::class.java,
        queryStructure,
        { qs: QueryStructure -> ImplSysUserQueryPro.WhereField(qs, SysUserEntity::class.java) },
        { qs: QueryStructure -> ImplSysUserQueryPro.OrderByField(qs, SysUserEntity::class.java) },
        { qs: QueryStructure -> ImplSysUserQueryPro.UpdateSetField(qs) },
        { qs: QueryStructure -> ImplSysUserQueryPro.WhereField(qs, Boolean::class.java) },
        { qs: QueryStructure -> ImplSysUserQueryPro.WhereField(qs, Boolean::class.java) },
    )

val SysUserQueryPro = createQuery(QueryStructure(from = QueryStructureFrom(ImplSysUserQueryPro.TABLE_NAME)))

val SysUserQueryProEx = QueryProEx(
    QueryStructure(from = QueryStructureFrom(ImplSysUserQueryPro.TABLE_NAME)),
    { qs: QueryStructure -> ImplSysUserQueryPro.WhereField<SysUserEntity, List<SysUserEntity>>(qs, SysUserEntity::class.java) },
    { ImplSysUserQueryPro.FieldsGenerator() },
    { qs -> createQuery(qs) }
)
