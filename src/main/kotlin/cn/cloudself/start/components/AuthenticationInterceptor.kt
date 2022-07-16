package cn.cloudself.start.components

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.exception.http.RequestUnauthorizedException
import cn.cloudself.start.service.ISysAuthService
import cn.cloudself.start.util.WebUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthenticationInterceptor @Autowired constructor(
    private val env: Environment,
    private val authService: ISysAuthService,
    @Value("\${cloudself.auth.required-by-default:false}") private val defaultLoginRequired: Boolean,
) : HandlerInterceptor {

    private val log = LoggerFactory.getLogger(AuthenticationInterceptor::class.java)

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (request.method == "OPTIONS") {
            return true
        }

        if (handler !is HandlerMethod && handler !is ResourceHttpRequestHandler) {
            log.warn("未知的切面: {}", handler)
            return false
        }

        // cookie中的token(dev环境允许使用url传输token)
        val token = request.cookies?.find { it.name == "ut" }?.value
            ?: if (env.activeProfiles[0] == "dev") {
                request.getParameter("token")
            } else { null }

        val userDefineLoginRequired = if (handler is HandlerMethod)
            handler.method.getAnnotation(LoginRequired::class.java)?.required
        else
            null

        val loginRequired = userDefineLoginRequired ?: defaultLoginRequired

        // 无需登陆
        val url = request.requestURI

        if (!loginRequired) {
            log.debug("无需登陆, url: {}", url)
            return true
        }

        // 需要登陆
        if (token == null) {
            log.info("需要登陆, url: {}", url)
            responseException(response, RequestUnauthorizedException("需要登陆"))
            return false
        }

        val tokenUser = try {
            authService.parseToken(token)
        } catch (e: Exception) {
            responseException(response, e)
            return false
        } ?: return false.also { responseException(response, RequestUnauthorizedException("无法解析token")) }
        WebUtil.setUser(tokenUser)

        return true
    }
}
