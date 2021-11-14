package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 用户定义字段信息(排序,隐藏)
 */
@Entity
@Table(name = "sys_search_user_config_column")
data class SysSearchUserConfigColumnEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** 用户ID */
    @Column(name = "sys_user_id")
    var sysUserId: Long? = null,

    /** 对应的查询方案列ID */
    @Column(name = "sys_search_config_column_property_name")
    var sysSearchConfigColumnPropertyName: Long? = null,

    /** 是否隐藏 */
    @Column(name = "hidden")
    var hidden: Boolean? = null,

    /** 排序信息 */
    @Column(name = "sort")
    var sort: Int? = null,

    /** 是否允许排序(对于操作列，是不能排序的) */
    @Column(name = "sortable")
    var sortable: Boolean? = null,

    /** 状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject] */
    @Column(name = "status")
    var status: String? = null,

    /** 创建者 */
    @Column(name = "create_by")
    var createBy: String? = null,

    /** 创建时间 */
    @Column(name = "create_time")
    var createTime: Date? = null,

    /** 更新者 */
    @Column(name = "update_by")
    var updateBy: String? = null,

    /** 更新时间 */
    @Column(name = "update_time")
    var updateTime: Date? = null,

    /** 删除标志 */
    @Column(name = "deleted")
    var deleted: Boolean? = null,

    /** 备注 */
    @Column(name = "remark")
    var remark: String? = null,

)
