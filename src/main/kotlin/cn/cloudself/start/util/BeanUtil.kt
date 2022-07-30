package cn.cloudself.start.util

import org.springframework.beans.BeanUtils

fun <T: Any> Any.copyTo(clazz: Class<T>, vararg ignoreProperties: String): T {
    val instance = clazz.getDeclaredConstructor().newInstance()
    BeanUtils.copyProperties(this, instance, *ignoreProperties)
    return instance
}
