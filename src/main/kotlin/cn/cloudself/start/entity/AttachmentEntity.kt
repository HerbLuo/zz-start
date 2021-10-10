package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 附件
 */
@Entity
@Table(name = "attachment")
data class AttachmentEntity(
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** 业务 */
    @Column(name = "business")
    var business: String? = null,

    /** 业务ID */
    @Column(name = "business_id")
    var businessId: Long? = null,

    /** 文件HASH */
    @Column(name = "hash")
    var hash: String? = null,

    /** 文件名 */
    @Column(name = "name")
    var name: String? = null,

    /** 文件大小(Byte) */
    @Column(name = "size")
    var size: Long? = null,

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
