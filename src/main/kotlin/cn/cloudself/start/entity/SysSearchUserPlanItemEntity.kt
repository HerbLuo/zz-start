package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 用户保存的查询方案明细
 */
@Entity
@Table(name = "sys_search_user_plan_item")
data class SysSearchUserPlanItemEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** 用户ID */
    @Column(name = "sys_user_id")
    var sysUserId: Long? = null,

    /** 查询方案ID */
    @Column(name = "sys_search_config_id")
    var sysSearchConfigId: Long? = null,

    /** 用户保存的查询方案主表ID */
    @Column(name = "sys_search_config_column_id")
    var sysSearchConfigColumnId: Long? = null,

    /** 条件 */
    @Column(name = "search_condition")
    var searchCondition: String? = null,

    /** 值 */
    @Column(name = "search_value")
    var searchValue: String? = null,

    /** 排序 */
    @Column(name = "sort")
    var sort: Int? = null,

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