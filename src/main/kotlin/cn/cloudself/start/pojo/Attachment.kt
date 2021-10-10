package cn.cloudself.start.pojo

/**
 * 附件信息对象 attachment
 */
data class Attachment(
    var name: String? = null,
    var size: Long? = null,
    var business: String? = null,
    var businessId: Long? = null,
    var sha256: String? = null
)
