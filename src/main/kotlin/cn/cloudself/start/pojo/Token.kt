package cn.cloudself.start.pojo

data class Token(
    val token: String,
)

data class TokenWithUser (
    val id: Long,
    val username: String,
)
