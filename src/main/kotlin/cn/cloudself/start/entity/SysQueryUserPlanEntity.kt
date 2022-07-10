package cn.cloudself.start.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date
import javax.persistence.*

/**
 * 用户保存的查询方案
 */
@Entity
@ApiModel(description = "用户保存的查询方案")
@Table(name = "sys_query_user_plan")
data class SysQueryUserPlanEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    @Column(name = "id")
    var id: Long? = null,

    /** 用户ID */
    @ApiModelProperty("用户ID")
    @Column(name = "sys_user_id")
    var sysUserId: Long? = null,

    /** 查询方案 */
    @ApiModelProperty("查询方案")
    @Column(name = "sys_query_id")
    var sysQueryId: Long? = null,

    /** 方案配置名(冗余字段) */
    @ApiModelProperty("方案配置名(冗余字段)")
    @Column(name = "sys_query_tag_cn_redundant")
    var sysQueryTagCnRedundant: String? = null,

    /** 用户定义的查询方案名称 */
    @ApiModelProperty("用户定义的查询方案名称")
    @Column(name = "name")
    var name: String? = null,

    /** 排序 */
    @ApiModelProperty("排序")
    @Column(name = "sort")
    var sort: Int? = null,

    /** 是否为默认方案 */
    @ApiModelProperty("是否为默认方案")
    @Column(name = "default")
    var default: Boolean? = null,

    /** 只读（针对公用方案, 只能拷贝不能修改） */
    @ApiModelProperty("只读（针对公用方案, 只能拷贝不能修改）")
    @Column(name = "readonly")
    var readonly: Boolean? = null,

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
