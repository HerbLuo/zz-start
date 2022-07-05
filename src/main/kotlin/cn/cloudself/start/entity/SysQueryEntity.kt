package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 查询方案配置
 */
@Entity
@Table(name = "sys_query")
data class SysQueryEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** 方案名(可用于查询，唯一) */
    @Column(name = "tag")
    var tag: String? = null,

    /** 方案名(备注, 可为中文) */
    @Column(name = "tag_cn")
    var tagCn: String? = null,

    /** sql */
    @Column(name = "sql")
    var sqlColumn: String? = null,

    /** hash */
    @Column(name = "hash")
    var hash: ByteArray? = null,

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
