package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.UsernamePassword
import cn.cloudself.start.service.ISysAuthService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@Api(tags = ["登陆与注册"])
@RestController
@RequestMapping("/account")
class SysAccountController @Autowired constructor(
    private val authService: ISysAuthService,
    @Value("\${cloudself.site.only-https:false}") private val onlyHttps: Boolean,
    @Value("\${cloudself.auth.remember-me-days:-1}") private val rememberMeMaxRememberDays: Int,
    @Value("\${cloudself.site.token-domain:}") private val tokenDomainMayEmpty: String,
) {

    private val tokenDomain = if (tokenDomainMayEmpty.isEmpty()) null else tokenDomainMayEmpty

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
        val days = if (rememberMeMaxRememberDays == -1) 365 * 30 else rememberMeMaxRememberDays
        val cookie = ResponseCookie
            .from(COOKIE_KEY_USER_REMEMBER_ME_TOKEN, token.rememberMeToken ?: return)
            .httpOnly(true)
            .sameSite("Lax")
            .maxAge((24L * 60 * 60 * days ) - (5 * 60))
            .let { if (onlyHttps) it.secure(true) else it }
            .let { it.domain(tokenDomain ?: return@let it) }
            .build()

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString())
    }

    private fun setTokenToCookie(response: HttpServletResponse, token: Token) {
        val cookie = ResponseCookie
            .from(COOKIE_KEY_USER_TOKEN, token.token)
            .path("/")
            .httpOnly(true)
            .sameSite("Lax")
            .let { if (onlyHttps) it.secure(true) else it }
            .let { it.domain(tokenDomain ?: return@let it) }
            .build()

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString())
    }

    companion object {
        private const val COOKIE_KEY_USER_REMEMBER_ME_TOKEN = "urt"
        private const val COOKIE_KEY_USER_TOKEN = "ut"
    }
}
