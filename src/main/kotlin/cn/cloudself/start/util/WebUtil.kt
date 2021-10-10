package cn.cloudself.start.util

import cn.cloudself.start.pojo.TokenUser
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder

object WebUtil {
    fun setUser(user: TokenUser) {
        RequestContextHolder.currentRequestAttributes().setAttribute("user", user, RequestAttributes.SCOPE_REQUEST)
    }

    fun getUser(): TokenUser? {
        return RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_REQUEST) as TokenUser?
    }
}