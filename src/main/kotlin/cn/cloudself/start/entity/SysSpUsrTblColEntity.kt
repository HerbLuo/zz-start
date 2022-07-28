package cn.cloudself.start.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date
import javax.persistence.*

/**
 * 用户定义字段信息(排序,隐藏)
 */
@Entity
@ApiModel(description = "用户定义字段信息(排序,隐藏)")
@Table(name = "sys_sp_usr_tbl_col")
data class SysSpUsrTblColEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    @Column(name = "id")
    var id: Long? = null,

    /** page tag */
    @ApiModelProperty("page tag")
    @Column(name = "page_tag")
    var pageTag: String? = null,

    /** 用户ID */
    @ApiModelProperty("用户ID")
    @Column(name = "sys_user_id")
    var sysUserId: Long? = null,

    /** 对应的查询方案列ID */
    @ApiModelProperty("对应的查询方案列ID")
    @Column(name = "sys_sp_ele_id")
    var sysSpEleId: Long? = null,

    /** 列名 */
    @ApiModelProperty("列名")
    @Column(name = "title")
    var title: String? = null,

    /** 数据键名 */
    @ApiModelProperty("数据键名")
    @Column(name = "data_index")
    var dataIndex: String? = null,

    /** 列类型(text, select, number, money, time, date, date-time, month, year) */
    @ApiModelProperty("列类型(text, select, number, money, time, date, date-time, month, year)")
    @Column(name = "type")
    var type: String? = null,

    /** 是否隐藏 */
    @ApiModelProperty("是否隐藏")
    @Column(name = "hidden")
    var hidden: Boolean? = null,

    /** 拖拽排序信息 */
    @ApiModelProperty("拖拽排序信息")
    @Column(name = "sort")
    var sort: Int? = null,

    /** 固定列，不允许排序 right, left */
    @ApiModelProperty("固定列，不允许排序 right, left")
    @Column(name = "fixed")
    var fixed: String? = null,

    /** asc, desc */
    @ApiModelProperty("asc, desc")
    @Column(name = "order_by")
    var orderByColumn: String? = null,

    /** 存在多个order_by字段时的先后顺序 */
    @ApiModelProperty("存在多个order_by字段时的先后顺序")
    @Column(name = "order_by_index")
    var orderByIndex: Int? = null,

    /** 宽度 */
    @ApiModelProperty("宽度")
    @Column(name = "width")
    var width: String? = null,

    /**  */
    @ApiModelProperty("")
    @Column(name = "css")
    var css: String? = null,

    /**  */
    @ApiModelProperty("")
    @Column(name = "render")
    var render: String? = null,

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
