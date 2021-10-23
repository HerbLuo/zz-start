package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.UsernamePassword
import cn.cloudself.start.service.ISysAuthService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["登陆与注册"])
@RestController
@RequestMapping("/account")
class SysAccountController @Autowired constructor(
    private val authService: ISysAuthService
) {

    @ApiOperation("使用用户名密码登陆")
    @LoginRequired(false)
    @PostMapping("/login")
    fun loginByPwd(@RequestBody login: UsernamePassword): Token {
        return authService.loginByPwd(login.username, login.password)
    }
}
