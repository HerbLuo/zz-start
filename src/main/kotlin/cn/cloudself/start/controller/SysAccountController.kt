package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.UsernamePassword
import cn.cloudself.start.service.ISysAuthService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@Api(tags = ["登陆与注册"])
@RestController
@RequestMapping("/account")
class SysAccountController @Autowired constructor(
    private val authService: ISysAuthService,
    @Value("\${cloudself.site.only-https:false}") private val onlyHttps: Boolean,
    @Value("\${cloudself.auth.remember-me-days:-1}") private val rememberMeMaxRememberDays: Int,
) {

    @ApiOperation("使用用户名密码登陆")
    @LoginRequired(false)
    @PostMapping("/login")
    fun loginByPwd(response: HttpServletResponse, @RequestBody login: UsernamePassword): Token {
        val token = authService.loginByPwd(login)
        setTokenToCookie(response, token)
        if (login.rememberMe) {
            setRememberMeTokenToCookie(response, token)
        }
        return token
    }

    @ApiOperation("使用RememberMeToken登陆")
    @LoginRequired(false)
    @PostMapping("/login/remember-me-token")
    fun loginByRememberMeToken(
        @CookieValue(COOKIE_KEY_USER_REMEMBER_ME_TOKEN) userRememberMeToken: String,
        response: HttpServletResponse
    ): Boolean {
        val token = authService.loginByRememberMeToken(userRememberMeToken)
        setTokenToCookie(response, token)
        return true
    }

    private fun setRememberMeTokenToCookie(response: HttpServletResponse, token: Token) {
        val cookie = Cookie(COOKIE_KEY_USER_REMEMBER_ME_TOKEN, token.rememberMeToken ?: return)
        cookie.isHttpOnly = true
        val days = if (rememberMeMaxRememberDays == -1) 365 * 30 else rememberMeMaxRememberDays
        cookie.maxAge = (days * 24 * 60 * 60) - (5 * 60)
        if (onlyHttps) cookie.secure = true
        response.addCookie(cookie)
    }

    private fun setTokenToCookie(response: HttpServletResponse, token: Token) {
        val cookie = Cookie(COOKIE_KEY_USER_TOKEN, token.token)
        cookie.path = "/"
        cookie.isHttpOnly = true
        if (onlyHttps) cookie.secure = true
        response.addCookie(cookie)
    }

    companion object {
        private const val COOKIE_KEY_USER_REMEMBER_ME_TOKEN = "urt"
        private const val COOKIE_KEY_USER_TOKEN = "ut"
    }
}
