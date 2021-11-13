package cn.cloudself.start.interactive.util

import cn.cloudself.start.util.Sha256WithRsa
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.util.LRUMap
import org.slf4j.LoggerFactory
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod

private val logger = LoggerFactory.getLogger(CouldSerializeMethod::class.java)
private val sha256WithRsa = Sha256WithRsa.create("zz-interactive")

typealias Callable = (args: Array<out Any?>) -> Any?
val serializeCache = LRUMap<KFunction<*>, String?>(100, 1000)
val deserializeCache = LRUMap<String, Callable?>(100, 1000)

data class CouldSerializeMethod(
    val className: String,
    val methodName: String,
)

fun KFunction<*>.serialize(): String {
    val cache = serializeCache.get(this)
    if (cache != null) {
        return cache
    }

    logger.info("缓存中不存在KFunction {}对应的序列化后的对象，序列化中", this)
    val methodName = this.name
    val className = this.javaMethod?.declaringClass?.name ?: throw RuntimeException("无法获取${this}的类信息")
    val serialized = ObjectMapper().writeValueAsString(CouldSerializeMethod(className, methodName))
    serializeCache.put(this, serialized)
    return serialized
}

fun invoke(serializedMethodStr: String, vararg args: Any?): Any? {
    val callableFunc = deserializeCache.get(serializedMethodStr)
        ?: ObjectMapper().readValue(serializedMethodStr, CouldSerializeMethod::class.java)
            .let {
                logger.info("缓存中不存在{}对应的方法, 生成中", it)

                val className = it.className
                val clazz = Class.forName(className)
                val methodName = it.methodName
                val method = clazz.methods.find { method -> method.name == methodName }
                    ?: throw RuntimeException("${className}中找不到对应的方法$methodName")

                val obj = RSUtils.getBean(clazz) ?: clazz.getDeclaredConstructor().newInstance()

                val func: Callable = { args -> method.invoke(obj, *args) }
                deserializeCache.put(serializedMethodStr, func)
                func
            }

    return callableFunc(args)
}

fun toUrlPart(serializedMethodStr: String): String {
    return sha256WithRsa.encrypt(serializedMethodStr)
}

fun parseUrlPartToSerializedStr(encryptMethodStr: String): String {
    return sha256WithRsa.decrypt(encryptMethodStr)
}
