package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 下拉列表
 */
@Entity
@Table(name = "sys_select_option")
data class SysSelectOptionEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** key */
    @Column(name = "key")
    var key: String? = null,

    /** 表 */
    @Column(name = "table")
    var table: String? = null,

    /** 标签 */
    @Column(name = "label")
    var label: String? = null,

    /** 列名 值 */
    @Column(name = "value")
    var value: String? = null,

    /** where子句 */
    @Column(name = "where_clause")
    var whereClause: String? = null,

    /** 获取默认值的子句 */
    @Column(name = "default_clause")
    var defaultClause: String? = null,

    /** order by 子句 */
    @Column(name = "order_by_clause")
    var orderByClause: String? = null,

    /** 获取payload的子句 */
    @Column(name = "payload")
    var payload: String? = null,

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
