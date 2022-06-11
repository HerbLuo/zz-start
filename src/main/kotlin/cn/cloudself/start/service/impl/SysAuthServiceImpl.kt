package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysUserQueryPro
import cn.cloudself.start.exception.http.RequestBadException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.TokenWithUser
import cn.cloudself.start.pojo.UsernamePassword
import cn.cloudself.start.service.ISysAuthService
import cn.cloudself.start.util.I18n
import cn.cloudself.start.util.i18n
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class SysAuthServiceImpl @Autowired constructor(
    @Value("\${cloudself.auth.jwt-secret}") private val jwtSecret: String,
    @Value("\${cloudself.auth.remember-me-days:-1}") private val rememberMeMaxRememberDays: Int,
    @Value("\${cloudself.auth.token-expire-time-seconds:43200}") private val tokenExpireTimeSeconds: Int,
) : ISysAuthService {

    override fun loginByPwd(usernamePassword: UsernamePassword): Token {
        val username = usernamePassword.username
        val user = SysUserQueryPro
            .selectBy().userName.equalsTo(username)
            .and().password.equalsTo(usernamePassword.password)
            .runLimit1() ?: throw RequestBadException(i18n("用户名或密码错误"))

        val id = user.id!!
        val token = getToken(TokenWithUser(id, username))
        if (usernamePassword.rememberMe) {
            token.rememberMeToken = getRememberMeToken(id)
        }
        return token
    }

    override fun loginByRememberMeToken(rememberMeToken: String): Token {
        val id = parseRememberToken(rememberMeToken)
        val usernameNullable = SysUserQueryPro.selectBy().id.equalsTo(id).columnLimiter().userName().getOrNull(0)
        val username = usernameNullable ?: throw ServerException(I18n("找不到该用户的用户名"), "ID: {}", id)
        return getToken(TokenWithUser(id, username))
    }

    override fun getToken(user: TokenWithUser): Token {
        val expireAt = Calendar.getInstance().also { it.add(Calendar.SECOND, tokenExpireTimeSeconds) }.time
        val token = JWT.create()
            .withClaim("id", user.id)
            .withClaim("username", user.username)
            .withExpiresAt(expireAt)
            .sign(Algorithm.HMAC256(jwtSecret))
        return Token(token, expireAt, null)
    }

    override fun parseToken(token: String): TokenWithUser? {
        val verify = JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token)
        return TokenWithUser(verify.getClaim("id").asLong(), verify.getClaim("username").asString())
    }

    private fun parseRememberToken(token: String): Long {
        val verify = JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token)
        return verify.getClaim(CLAIM_NAME_REMEMBER_ME_USER_ID).asLong()
    }

    private fun getRememberMeToken(id: Long): String {
        return JWT.create()
            .withClaim(CLAIM_NAME_REMEMBER_ME_USER_ID, id)
            .let {
                if (rememberMeMaxRememberDays != -1) {
                    val calendar = Calendar.getInstance()
                    calendar.add(Calendar.HOUR, rememberMeMaxRememberDays * 24)
                    it.withExpiresAt(calendar.time)
                } else {
                    it
                }
            }
            .sign(Algorithm.HMAC256(jwtSecret))
    }

    companion object {
        private const val CLAIM_NAME_REMEMBER_ME_USER_ID = "remember-me-user-id"
    }
}
