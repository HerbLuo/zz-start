package cn.cloudself.start.service

import cn.cloudself.start.pojo.Login
import cn.cloudself.start.pojo.Token

interface ISysAuthService {
    fun loginByPwd(login: Login): Token
}
