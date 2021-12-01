package cn.cloudself.http

import cn.cloudself.start.pojo.UsernamePassword
import org.json.JSONObject

fun url(part: String): String = "http://localhost:8880$part"

fun withTokenUrl(urlPart: String) = url(withToken(urlPart))

fun withToken(urlPart: String): String {
    val tokenRes = post(url("/account/login"), UsernamePassword("loo", "123456"))
    val token = JSONObject(tokenRes).getJSONObject("data").getString("token")
    return "$urlPart?token=$token"
}
