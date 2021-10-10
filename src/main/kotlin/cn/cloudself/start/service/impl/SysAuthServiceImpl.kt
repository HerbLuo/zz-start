package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysUserQueryPro
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.TokenUser
import cn.cloudself.start.service.ISysAuthService
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
            .runLimit1() ?: throw RequestBadException("用户名或密码错误")

        val id = user.id ?: throw ServerException("无ID")
        return getToken(TokenUser(id, username))
    }

    override fun getToken(user: TokenUser): Token {
        val expireAt = Calendar.getInstance().also { it.add(Calendar.SECOND, 3600) }.time
        val token = JWT.create()
            .withClaim("id", user.id)
            .withClaim("username", user.username)
            .withExpiresAt(expireAt)
            .sign(Algorithm.HMAC256(jwtSecret))
        return Token(token)
    }

    override fun parseToken(token: String): TokenUser? {
        val verify = JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token)
        return TokenUser(verify.getClaim("id").asLong(), verify.getClaim("username").asString())
    }
}
