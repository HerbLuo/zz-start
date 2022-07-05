@file:Suppress("unused")

package cn.cloudself.start.dao

import cn.cloudself.start.entity.SysUserEntity
import java.util.Date
import cn.cloudself.query.*
import org.jetbrains.annotations.Contract;


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
        override fun getPayload() = SysUserQueryPro.payload
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
        val userName = createWhereField("user_name")
        @Contract(pure = true)
        fun userName(userNameList: List<String>) = createWhereField("user_name", userNameList.toTypedArray())
        @Contract(pure = true)
        fun userName(vararg userNames: String) = createWhereField("user_name", userNames)
        val nickName = createWhereField("nick_name")
        @Contract(pure = true)
        fun nickName(nickNameList: List<String>) = createWhereField("nick_name", nickNameList.toTypedArray())
        @Contract(pure = true)
        fun nickName(vararg nickNames: String) = createWhereField("nick_name", nickNames)
        val email = createWhereField("email")
        @Contract(pure = true)
        fun email(emailList: List<String>) = createWhereField("email", emailList.toTypedArray())
        @Contract(pure = true)
        fun email(vararg emails: String) = createWhereField("email", emails)
        val phone = createWhereField("phone")
        @Contract(pure = true)
        fun phone(phoneList: List<String>) = createWhereField("phone", phoneList.toTypedArray())
        @Contract(pure = true)
        fun phone(vararg phones: String) = createWhereField("phone", phones)
        val sex = createWhereField("sex")
        @Contract(pure = true)
        fun sex(sexList: List<String>) = createWhereField("sex", sexList.toTypedArray())
        @Contract(pure = true)
        fun sex(vararg sexs: String) = createWhereField("sex", sexs)
        val avatar = createWhereField("avatar")
        @Contract(pure = true)
        fun avatar(avatarList: List<String>) = createWhereField("avatar", avatarList.toTypedArray())
        @Contract(pure = true)
        fun avatar(vararg avatars: String) = createWhereField("avatar", avatars)
        val password = createWhereField("password")
        @Contract(pure = true)
        fun password(passwordList: List<String>) = createWhereField("password", passwordList.toTypedArray())
        @Contract(pure = true)
        fun password(vararg passwords: String) = createWhereField("password", passwords)
        val loginIp = createWhereField("login_ip")
        @Contract(pure = true)
        fun loginIp(loginIpList: List<String>) = createWhereField("login_ip", loginIpList.toTypedArray())
        @Contract(pure = true)
        fun loginIp(vararg loginIps: String) = createWhereField("login_ip", loginIps)
        val loginDate = createWhereField("login_date")
        @Contract(pure = true)
        fun loginDate(loginDateList: List<Date>) = createWhereField("login_date", loginDateList.toTypedArray())
        @Contract(pure = true)
        fun loginDate(vararg loginDates: Date) = createWhereField("login_date", loginDates)
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
        fun userName() = createOrderByField("user_name")
        @Contract(pure = true)
        fun nickName() = createOrderByField("nick_name")
        @Contract(pure = true)
        fun email() = createOrderByField("email")
        @Contract(pure = true)
        fun phone() = createOrderByField("phone")
        @Contract(pure = true)
        fun sex() = createOrderByField("sex")
        @Contract(pure = true)
        fun avatar() = createOrderByField("avatar")
        @Contract(pure = true)
        fun password() = createOrderByField("password")
        @Contract(pure = true)
        fun loginIp() = createOrderByField("login_ip")
        @Contract(pure = true)
        fun loginDate() = createOrderByField("login_date")
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

        @Contract(pure = true)
        fun id() = createColumnsLimiterField("id")
        @Contract(pure = true)
        fun userName() = createColumnsLimiterField("user_name")
        @Contract(pure = true)
        fun nickName() = createColumnsLimiterField("nick_name")
        @Contract(pure = true)
        fun email() = createColumnsLimiterField("email")
        @Contract(pure = true)
        fun phone() = createColumnsLimiterField("phone")
        @Contract(pure = true)
        fun sex() = createColumnsLimiterField("sex")
        @Contract(pure = true)
        fun avatar() = createColumnsLimiterField("avatar")
        @Contract(pure = true)
        fun password() = createColumnsLimiterField("password")
        @Contract(pure = true)
        fun loginIp() = createColumnsLimiterField("login_ip")
        @Contract(pure = true)
        fun loginDate() = createColumnsLimiterField("login_date")
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
        fun userName(userName: Any) = createUpdateSetField("user_name", userName)
        @Contract(pure = true)
        fun nickName(nickName: Any) = createUpdateSetField("nick_name", nickName)
        @Contract(pure = true)
        fun email(email: Any) = createUpdateSetField("email", email)
        @Contract(pure = true)
        fun phone(phone: Any) = createUpdateSetField("phone", phone)
        @Contract(pure = true)
        fun sex(sex: Any) = createUpdateSetField("sex", sex)
        @Contract(pure = true)
        fun avatar(avatar: Any) = createUpdateSetField("avatar", avatar)
        @Contract(pure = true)
        fun password(password: Any) = createUpdateSetField("password", password)
        @Contract(pure = true)
        fun loginIp(loginIp: Any) = createUpdateSetField("login_ip", loginIp)
        @Contract(pure = true)
        fun loginDate(loginDate: Any) = createUpdateSetField("login_date", loginDate)
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
