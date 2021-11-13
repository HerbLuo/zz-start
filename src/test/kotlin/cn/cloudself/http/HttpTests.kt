package cn.cloudself.http

import cn.cloudself.start.exception.http.RequestUnauthorizedException
import cn.cloudself.start.pojo.UsernamePassword
import org.json.JSONObject
import org.junit.jupiter.api.Test

fun url(part: String): String = "http://localhost:8880$part"

class HttpTests {
    @Test
    fun loginByPwd() {
        post(url("/account/login"), UsernamePassword("loo", "123456"))
            .also { println(it) }
    }

    @Test
    fun testLogin() {
        get(withTokenUrl("/db/test"))
            .also { println(it) }
    }

    @Test
    fun testConfirm() {
        get(withTokenUrl("/confirm/foo"))
            .also { println(it) }
    }

    private fun withTokenUrl(part: String): String {
        val tokenRes = post(url("/account/login"), UsernamePassword("loo", "123456"))
        val token = JSONObject(tokenRes).getJSONObject("data").getString("token")
        println(token)
        return url("$part?token=$token")
    }
}
