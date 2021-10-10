package cn.cloudself.start.service.impl

import cn.cloudself.start.pojo.Login
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.service.ISysAuthService
import org.springframework.stereotype.Service

@Service
class SysAuthServiceImpl : ISysAuthService {
    override fun loginByPwd(login: Login): Token {
        return Token("totttttken")
    }
}
