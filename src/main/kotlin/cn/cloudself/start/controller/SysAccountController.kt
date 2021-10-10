package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.Login
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.service.ISysAuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class SysAccountController @Autowired constructor(
    private val authService: ISysAuthService
) {

    @LoginRequired(false)
    @PostMapping("/login")
    fun loginByPwd(@RequestBody login: Login): Token {
        return authService.loginByPwd(login)
    }
}
