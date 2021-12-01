package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 查询方案配置列
 */
@Entity
@Table(name = "sys_search_config_column")
data class SysSearchConfigColumnEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** 主键ID */
    @Column(name = "sys_search_config_id")
    var sysSearchConfigId: Long? = null,

    /** 方案名(冗余字段) */
    @Column(name = "sys_search_config_name_redundant")
    var sysSearchConfigNameRedundant: String? = null,

    /** 属性名(作为字段名) */
    @Column(name = "column")
    var column: String? = null,

    /** 属性名(显示用) */
    @Column(name = "column_name")
    var columnName: String? = null,

    /** 属性sql */
    @Column(name = "column_sql")
    var columnSql: String? = null,

    /** 类型(text, select, number, time, date, date-time, month, year) */
    @Column(name = "type")
    var type: String? = null,

    /** 允许的搜索条件 */
    @Column(name = "conditions")
    var conditions: String? = null,

    /** 限定类型(values, dictionary, select_option, url) */
    @Column(name = "limit_type")
    var limitType: String? = null,

    /** 排序 */
    @Column(name = "sort")
    var sort: Int? = null,

    /** 隐藏 */
    @Column(name = "hidden")
    var hidden: Boolean? = null,

    /** 排序字段 */
    @Column(name = "order_by")
    var orderByColumn: Boolean? = null,

    /** 倒序排序字段 */
    @Column(name = "order_by_desc")
    var orderByDesc: Boolean? = null,

    /** 限定值 */
    @Column(name = "limit_values")
    var limitValues: String? = null,

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
