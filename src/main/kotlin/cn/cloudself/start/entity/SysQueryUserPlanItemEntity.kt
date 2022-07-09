package cn.cloudself.start.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date
import javax.persistence.*

/**
 * 用户保存的查询方案明细
 */
@Entity
@ApiModel(description = "用户保存的查询方案明细")
@Table(name = "sys_query_user_plan_item")
data class SysQueryUserPlanItemEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    @Column(name = "id")
    var id: Long? = null,

    /**  */
    @ApiModelProperty("")
    @Column(name = "sys_query_id")
    var sysQueryId: Long? = null,

    /** 表头ID */
    @ApiModelProperty("表头ID")
    @Column(name = "sys_query_user_plan_id")
    var sysQueryUserPlanId: Long? = null,

    /** 对应的查询方案列ID */
    @ApiModelProperty("对应的查询方案列ID")
    @Column(name = "sys_query_element_id")
    var sysQueryElementId: Long? = null,

    /** 用户ID(冗余) */
    @ApiModelProperty("用户ID(冗余)")
    @Column(name = "sys_user_id_redundant")
    var sysUserIdRedundant: Long? = null,

    /** 查询方案配置名(冗余) */
    @ApiModelProperty("查询方案配置名(冗余)")
    @Column(name = "sys_query_tag_cn_redundant")
    var sysQueryTagCnRedundant: Long? = null,

    /** 字段sql */
    @ApiModelProperty("字段sql")
    @Column(name = "column_sql")
    var columnSql: String? = null,

    /** 条件 */
    @ApiModelProperty("条件")
    @Column(name = "search_condition")
    var searchCondition: String? = null,

    /** 值 */
    @ApiModelProperty("值")
    @Column(name = "search_value")
    var searchValue: String? = null,

    /** 排序 */
    @ApiModelProperty("排序")
    @Column(name = "sort")
    var sort: Int? = null,

    /** 状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject] */
    @ApiModelProperty("状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]")
    @Column(name = "status")
    var status: String? = null,

    /** 创建者 */
    @ApiModelProperty("创建者")
    @Column(name = "create_by")
    var createBy: String? = null,

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    var createTime: Date? = null,

    /** 更新者 */
    @ApiModelProperty("更新者")
    @Column(name = "update_by")
    var updateBy: String? = null,

    /** 更新时间 */
    @ApiModelProperty("更新时间")
    @Column(name = "update_time")
    var updateTime: Date? = null,

    /** 删除标志 */
    @ApiModelProperty("删除标志")
    @Column(name = "deleted")
    var deleted: Boolean? = null,

    /** 备注 */
    @ApiModelProperty("备注")
    @Column(name = "remark")
    var remark: String? = null,

)
