package cn.cloudself.start.util

import cn.cloudself.start.exception.http.RequestUnauthorizedException
import cn.cloudself.start.pojo.TokenWithUser
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder

object WebUtil {
    @JvmStatic
    fun setUser(user: TokenWithUser) {
        RequestContextHolder.currentRequestAttributes().setAttribute("user", user, RequestAttributes.SCOPE_REQUEST)
    }

    @JvmStatic
    fun getUser(): TokenWithUser? {
        return RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_REQUEST) as TokenWithUser?
    }

    @JvmStatic
    fun getUserId() = getUser()?.id

    @JvmStatic
    fun getUserIdNonNull() = getUserId() ?: throw RequestUnauthorizedException("[BUG] 该方法必须认证, 但可能未被认证拦截器拦截。 ")
}