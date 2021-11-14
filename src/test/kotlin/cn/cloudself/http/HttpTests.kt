package cn.cloudself.http

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
        val confirmRes = get(withTokenUrl("/zz/test/interactive/confirm"))
        println("res: $confirmRes")
        val url = JSONObject(confirmRes).getJSONObject("data").getJSONObject("okUrl").getString("url")
        val body = mapOf("id" to 1L)
        val confirmedRes = post(withToken(url), body)
        println("res: $confirmedRes")
    }

    private fun withTokenUrl(urlPart: String) = url(withToken(urlPart))

    private fun withToken(urlPart: String): String {
        val tokenRes = post(url("/account/login"), UsernamePassword("loo", "123456"))
        val token = JSONObject(tokenRes).getJSONObject("data").getString("token")
        return "$urlPart?token=$token"
    }
}
