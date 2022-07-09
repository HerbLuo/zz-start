package cn.cloudself.start.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date
import javax.persistence.*

/**
 * 字典值
 */
@Entity
@ApiModel(description = "字典值")
@Table(name = "sys_dict_data")
data class SysDictDataEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    @Column(name = "id")
    var id: Long? = null,

    /** 类型 */
    @ApiModelProperty("类型")
    @Column(name = "type")
    var type: String? = null,

    /** 名称 */
    @ApiModelProperty("名称")
    @Column(name = "label")
    var label: String? = null,

    /** 值 */
    @ApiModelProperty("值")
    @Column(name = "value")
    var value: String? = null,

    /** 排序 */
    @ApiModelProperty("排序")
    @Column(name = "sort")
    var sort: Int? = null,

    /** 是否为默认 */
    @ApiModelProperty("是否为默认")
    @Column(name = "is_default")
    var isDefault: Boolean? = null,

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
