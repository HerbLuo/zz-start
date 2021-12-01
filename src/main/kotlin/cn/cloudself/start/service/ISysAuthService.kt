package cn.cloudself.start.service

import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.TokenWithUser

interface ISysAuthService {
    fun loginByPwd(username: String, password: String): Token

    fun getToken(user: TokenWithUser): Token

    fun parseToken(token: String): TokenWithUser?
}
