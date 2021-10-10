package cn.cloudself.start.entity

import java.util.Date
import javax.persistence.*

/**
 * 用户信息表
 */
@Entity
@Table(name = "sys_user")
data class SysUserEntity(
    /** 用户ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /** 用户账号 */
    @Column(name = "user_name")
    var userName: String? = null,

    /** 用户昵称 */
    @Column(name = "nick_name")
    var nickName: String? = null,

    /** 用户邮箱 */
    @Column(name = "email")
    var email: String? = null,

    /** 手机号码 */
    @Column(name = "phone")
    var phone: String? = null,

    /** 用户性别（0男 1女 2未知） */
    @Column(name = "sex")
    var sex: String? = null,

    /** 头像地址 */
    @Column(name = "avatar")
    var avatar: String? = null,

    /** 密码 */
    @Column(name = "password")
    var password: String? = null,

    /** 最后登录IP */
    @Column(name = "login_ip")
    var loginIp: String? = null,

    /** 最后登录时间 */
    @Column(name = "login_date")
    var loginDate: Date? = null,

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
