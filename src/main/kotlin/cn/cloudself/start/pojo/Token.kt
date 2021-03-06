package cn.cloudself.start.pojo

import java.util.*

data class Token(
    val token: String,
    val expireAt: Date,
    var rememberMeToken: String?,
)

data class TokenWithUser (
    val id: Long,
    val username: String,
)
