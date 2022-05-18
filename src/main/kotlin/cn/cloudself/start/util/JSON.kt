package cn.cloudself.start.util

import cn.cloudself.start.exception.IllegalCall
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.text.SimpleDateFormat
import java.util.*

object JSON {
    fun stringify(obj: Any): String {
        return try {
            ObjectMapper()
                .setTimeZone(TimeZone.getTimeZone("GMT+8:00"))
                .setDateFormat(SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .writeValueAsString(obj)
        } catch (e: JsonProcessingException) {
            throw IllegalCall("JSON stringify 失败, {} {}", obj.javaClass.name, obj)
        }
    }

    fun <V> parse(json: String?, clazz: TypeReference<V>?): V {
        return try {
            ObjectMapper()
                .setTimeZone(TimeZone.getTimeZone("GMT+8:00"))
                .setDateFormat(SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .readValue(json, clazz)
        } catch (e: JsonProcessingException) {
            throw IllegalCall("JSON 解析 失败, {} {}", json, clazz)
        }
    }

    fun <V> parse(json: String?, clazz: Class<V>?): V {
        return try {
            ObjectMapper()
                .setDateFormat(SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .readValue(json, clazz)
        } catch (e: JsonProcessingException) {
            throw IllegalCall("JSON 解析 失败, {} {}", json, clazz)
        }
    }
}