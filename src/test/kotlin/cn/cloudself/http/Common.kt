package cn.cloudself.http

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.IOUtils
import java.net.HttpURLConnection
import java.net.URL

fun get(httpUrl: String): String {
    val url = URL(httpUrl)
    val connection = (url.openConnection() as HttpURLConnection).also {
        it.requestMethod = "GET"
        it.connect()
    }
    val inputStream = connection.inputStream
    val body = IOUtils.toString(inputStream, "UTF-8")
    println("get request url: $url, code: ${connection.responseCode}, body: $body")
    return body
}

fun <T> get(httpUrl: String, clazz: Class<T>): T {
    val url = URL(httpUrl)
    val connection = (url.openConnection() as HttpURLConnection).also {
        it.requestMethod = "GET"
        it.connect()
    }
    val inputStream = connection.inputStream
    return ObjectMapper().readValue(inputStream, clazz)
}

fun post(httpUrl: String, requestBody: Any): String {
    val url = URL(httpUrl)
    val connection = (url.openConnection() as HttpURLConnection).also {
        it.requestMethod = "POST"
        it.doOutput = true
        it.setRequestProperty("Content-Type", "application/json;")
        it.outputStream.write(ObjectMapper().writeValueAsBytes(requestBody))
    }
    val inputStream = connection.inputStream
    val responseBody = IOUtils.toString(inputStream, "UTF-8")
    println("get request url: $url, code: ${connection.responseCode}, body: $responseBody")
    return responseBody
}

fun <T> post(httpUrl: String, requestBody: Any, clazz: Class<T>): T {
    val url = URL(httpUrl)
    val connection = (url.openConnection() as HttpURLConnection).also {
        it.requestMethod = "POST"
        it.doOutput = true
        it.setRequestProperty("Content-Type", "application/json;")
        it.outputStream.write(ObjectMapper().writeValueAsBytes(requestBody))
    }
    val inputStream = connection.inputStream
    return ObjectMapper().readValue(inputStream, clazz)
}
