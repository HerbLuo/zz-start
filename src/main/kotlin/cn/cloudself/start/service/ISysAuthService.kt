package cn.cloudself.start.service

import cn.cloudself.start.pojo.RememberMeToken
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.TokenWithUser
import cn.cloudself.start.pojo.UsernamePassword

interface ISysAuthService {
    fun loginByPwd(usernamePassword: UsernamePassword): Token

    fun loginByRememberMeToken(rememberMeToken: String): Token

    fun getToken(user: TokenWithUser): Token

    fun parseToken(token: String): TokenWithUser?
}
