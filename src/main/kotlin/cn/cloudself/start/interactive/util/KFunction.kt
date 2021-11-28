package cn.cloudself.start.interactive.util

import cn.cloudself.start.util.Sha256WithRsa
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.util.LRUMap
import org.slf4j.LoggerFactory
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod

private val logger = LoggerFactory.getLogger(CouldSerializeMethod::class.java)
private val sha256WithRsa = Sha256WithRsa.create("zz-interactive")

typealias SerializedMethod = String
typealias MethodUrlPart = String
typealias ArgNames = List<String>
typealias SerializedMethodWithArgNames = Pair<SerializedMethod, ArgNames>
typealias MyCallable = (args: Map<String, Any?>) -> Any?

val serializeCache = LRUMap<KFunction<*>, Pair<SerializedMethod, ArgNames>?>(100, 1000)
val deserializeCache = LRUMap<String, MyCallable?>(100, 1000)

data class CouldSerializeMethod(
    val className: String = "",
    val methodName: String = "",
)

fun KFunction<*>.serialize(): SerializedMethodWithArgNames {
    val cache = serializeCache.get(this)
    if (cache != null) {
        return cache
    }

    logger.info("缓存中不存在KFunction {}对应的序列化后的对象，序列化中", this)
    val methodName = this.name
    val className = this.javaMethod?.declaringClass?.name ?: throw RuntimeException("无法获取${this}的类信息")
    val serializedMethod = ObjectMapper().writeValueAsString(CouldSerializeMethod(className, methodName))
    val argNames = this.parameters
        .filterIndexed { index, _ -> index != 0 }
        .mapIndexed { index, param -> param.name ?: index.toString() }
    val serializedMethodWithArgNames = serializedMethod to argNames
    serializeCache.put(this, serializedMethodWithArgNames)
    return serializedMethodWithArgNames
}

fun invoke(serializedMethod: SerializedMethod, argsMap: Map<String, Any?>): Any? {
    val callableFunc = deserializeCache.get(serializedMethod)
        ?: ObjectMapper().readValue(serializedMethod, CouldSerializeMethod::class.java)
            .let {
                logger.info("缓存中不存在{}对应的方法, 生成中", it)

                val className = it.className
                val clazz = Class.forName(className)
                val methodName = it.methodName
                val method = clazz.methods.find { method -> method.name == methodName }
                    ?: throw RuntimeException("${className}中找不到对应的方法$methodName")
                val parameterNames = method.parameters
                    .mapIndexed { index, parameter -> parameter.name ?: index.toString() }
                logger.info("{} 该方法的参数名称为{}", it, parameterNames)

                val obj = RSUtils.getBean(clazz) ?: clazz.getDeclaredConstructor().newInstance()

                val func: MyCallable = { relArgsMap ->
                    val args = parameterNames.map { paramName -> relArgsMap[paramName] }.toTypedArray()
                    method.invoke(obj, *args)
                }
                deserializeCache.put(serializedMethod, func)
                func
            }

    return callableFunc(argsMap)
}

fun runMethod(urlPart: String, argMap: Map<String, Any?>): Any? {
    val serializedMethod = urlPartToSerializedMethodWithArgMap(urlPart)
    return invoke(serializedMethod, argMap)
}

fun serializedMethodToMethodUrlPart(serializedMethod: SerializedMethod): MethodUrlPart {
    return sha256WithRsa.encrypt(serializedMethod).replace("/", "-")
}

fun urlPartToSerializedMethodWithArgMap(urlPart: MethodUrlPart): SerializedMethod {
    return sha256WithRsa.decrypt(urlPart.replace("-", "/"))
}
