package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysUserQueryPro
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.TokenWithUser
import cn.cloudself.start.service.ISysAuthService
import cn.cloudself.start.util.i18n
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class SysAuthServiceImpl : ISysAuthService {

    @Value("\${cloudself.jwt-secret}")
    private val jwtSecret = ""

    override fun loginByPwd(username: String, password: String): Token {
        val user = SysUserQueryPro
            .selectBy().userName.equalsTo(username)
            .and().password.equalsTo(password)
            .runLimit1() ?: throw RequestBadException(i18n("用户名或密码错误"))

        val id = user.id!!
        return getToken(TokenWithUser(id, username))
    }

    override fun getToken(user: TokenWithUser): Token {
        val expireAt = Calendar.getInstance().also { it.add(Calendar.SECOND, 3600) }.time
        val token = JWT.create()
            .withClaim("id", user.id)
            .withClaim("username", user.username)
            .withExpiresAt(expireAt)
            .sign(Algorithm.HMAC256(jwtSecret))
        return Token(token, expireAt)
    }

    override fun parseToken(token: String): TokenWithUser? {
        val verify = JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token)
        return TokenWithUser(verify.getClaim("id").asLong(), verify.getClaim("username").asString())
    }
}
