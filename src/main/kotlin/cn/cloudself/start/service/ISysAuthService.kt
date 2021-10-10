package cn.cloudself.start.service

import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.TokenUser

interface ISysAuthService {
    fun loginByPwd(username: String, password: String): Token

    fun getToken(user: TokenUser): Token
}
