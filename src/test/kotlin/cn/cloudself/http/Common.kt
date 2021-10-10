package cn.cloudself.http

import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

val client = HttpClient.newHttpClient()!!

fun get(url: String): String {
    val request = HttpRequest.newBuilder(URI.create(url)).build()
    return client.send(request, HttpResponse.BodyHandlers.ofString()).body()
}

fun <T> get(url: String, clazz: Class<T>): T {
    val request = HttpRequest.newBuilder(URI.create(url)).build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofInputStream())
    return ObjectMapper().readValue(response.body(), clazz)
}

fun post(url: String, body: Any): String {
    val request = HttpRequest.newBuilder(URI.create(url))
        .headers("Content-Type", "application/json;")
        .POST(HttpRequest.BodyPublishers.ofString(ObjectMapper().writeValueAsString(body)))
        .build()
    return client.send(request, HttpResponse.BodyHandlers.ofString()).body()
}

fun <T> post(url: String, body: Any, clazz: Class<T>): T {
    val request = HttpRequest.newBuilder(URI.create(url))
        .headers("Content-Type", "application/json;")
        .POST(HttpRequest.BodyPublishers.ofString(ObjectMapper().writeValueAsString(body)))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofInputStream())
    return ObjectMapper().readValue(response.body(), clazz)
}
