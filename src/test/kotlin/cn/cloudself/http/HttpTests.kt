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
    fun test() {
        val tokenRes = post(url("/account/login"), UsernamePassword("loo", "123456"))
        val token = JSONObject(tokenRes).getJSONObject("data").getString("token")
        println(token)

        get(url("/db/test?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjMzODgwODg0LCJ1c2VybmFtZSI6ImxvbyJ9.mUmJACQcEjQVIaAqhtyEK5pBshD4bGrXwXQyfj6caxQ"))
            .also { println(it) }
    }

//    fun
}
