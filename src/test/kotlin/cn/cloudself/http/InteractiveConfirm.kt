package cn.cloudself.http

import org.json.JSONObject
import org.junit.jupiter.api.Test

class InteractiveConfirm {
    @Test
    fun test() {
        val confirmRes = get(withTokenUrl("/zz/test/interactive/confirm"))
        println("res: $confirmRes")
        val url = JSONObject(confirmRes).getJSONObject("data").getJSONObject("okUrl").getString("url")
        val body = mapOf("id" to 1L)
        val confirmedRes = post(withToken(url), body)
        println("res: $confirmedRes")
    }
}
