package cn.cloudself.start.util

import cn.cloudself.start.exception.http.RequestUnauthorizedException
import cn.cloudself.start.pojo.TokenUser
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder

object WebUtil {
    @JvmStatic
    fun setUser(user: TokenUser) {
        RequestContextHolder.currentRequestAttributes().setAttribute("user", user, RequestAttributes.SCOPE_REQUEST)
    }

    @JvmStatic
    fun getUser(): TokenUser? {
        return RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_REQUEST) as TokenUser?
    }

    @JvmStatic
    fun getUserId() = getUser()?.id

    @JvmStatic
    fun getUserIdNonNull() = getUserId() ?: throw RequestUnauthorizedException(message = "[BUG] 该方法必须认证, 但未被认证拦截器拦截。")
}