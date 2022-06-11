package cn.cloudself.start.pojo

/**
 * 用户名+密码
 */
data class UsernamePassword(
    val username: String,
    val password: String,
    val rememberMe: Boolean = false,
)

data class RememberMeToken(
    val token: String
)

