package cn.cloudself.start.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date
import javax.persistence.*

/**
 * 查询方案配置列
 */
@Entity
@ApiModel(description = "查询方案配置列")
@Table(name = "sys_query_element")
data class SysQueryElementEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    @Column(name = "id")
    var id: Long? = null,

    /** 主键ID */
    @ApiModelProperty("主键ID")
    @Column(name = "sys_query_id")
    var sysQueryId: Long? = null,

    /** 方案名(冗余字段) */
    @ApiModelProperty("方案名(冗余字段)")
    @Column(name = "sys_query_tag_cn_redundant")
    var sysQueryTagCnRedundant: String? = null,

    /** 属性名(作为字段名) */
    @ApiModelProperty("属性名(作为字段名)")
    @Column(name = "alias")
    var alias: String? = null,

    /** 属性名(显示用) */
    @ApiModelProperty("属性名(显示用)")
    @Column(name = "alias_cn")
    var aliasCn: String? = null,

    /** 属性sql */
    @ApiModelProperty("属性sql")
    @Column(name = "sql")
    var sqlColumn: String? = null,

    /** 允许的搜索条件 */
    @ApiModelProperty("允许的搜索条件")
    @Column(name = "limit_conditions")
    var limitConditions: String? = null,

    /** 限定类型(可选)(values, dictionary, select_option, url) */
    @ApiModelProperty("限定类型(可选)(values, dictionary, select_option, url)")
    @Column(name = "limit_type")
    var limitType: String? = null,

    /** 限定值 */
    @ApiModelProperty("限定值")
    @Column(name = "limit_values")
    var limitValues: String? = null,

    /** 类型(text, select, number, time, date, date-time, month, year) */
    @ApiModelProperty("类型(text, select, number, time, date, date-time, month, year)")
    @Column(name = "type")
    var type: String? = null,

    /** 是否在列表中隐藏 */
    @ApiModelProperty("是否在列表中隐藏")
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
