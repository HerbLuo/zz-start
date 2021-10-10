package cn.cloudself.http

import cn.cloudself.start.pojo.UsernamePassword
import org.junit.jupiter.api.Test

fun url(part: String): String = "http://localhost:8880$part"

class HttpTests {
    @Test
    fun loginByPwd() {
        post(url("/account/login"), UsernamePassword("loo", "123456"))
            .also { println(it) }
    }
}
