package cn.cloudself.http

import cn.cloudself.start.pojo.UsernamePassword
import org.junit.jupiter.api.Test


class SysAccount {
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
}
