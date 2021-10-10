package cn.cloudself.start.components

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.service.IUserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
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
    private val userService: IUserService,
) : HandlerInterceptor {

    private val log = LoggerFactory.getLogger(AuthenticationInterceptor::class.java)

    @Value("\${cloudself.default-login-required}")
    private val defaultLoginRequired = false

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler !is HandlerMethod && handler !is ResourceHttpRequestHandler) {
            log.warn("未知的切面: {}", handler)
            return false;
        }

        // header中的token(dev环境允许使用url传输token)
        val token = request.getHeader("Authorization")
            ?: if (env.activeProfiles[0] == "dev") {
                request.getParameter("token")
            } else { null }

        val userDefineLoginRequired = if (handler is HandlerMethod)
            handler.method.getAnnotation(LoginRequired::class.java)?.required
        else
            null

        val loginRequired = userDefineLoginRequired ?: defaultLoginRequired

        // 无需登陆
        if (!loginRequired) {
            return true
        }

        // 需要登陆
        if (token == null) {
            log.info("需要登陆, url: {}", request.requestURL)
            responseException(response, RequestBadException("需要登陆"))
            return false
        }

        return true
    }
}
