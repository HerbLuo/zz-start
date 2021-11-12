package cn.cloudself.start.react

import java.io.Serializable
import java.lang.invoke.SerializedLambda
import java.lang.reflect.InvocationTargetException
import java.util.function.Supplier

data class Method(
    val className: String,
    val methodName: String,
)

@FunctionalInterface
interface Function<R> : Supplier<R>, Serializable

fun toMethodInfo(func: Function<*>): Method {
    val writeReplaceMethod: java.lang.reflect.Method = try {
        func.javaClass.getDeclaredMethod("writeReplace")
    } catch (e: NoSuchMethodException) {
        e.printStackTrace()
        throw RuntimeException("没有找到该方法")
    }

    writeReplaceMethod.isAccessible = true
    val serializedLambda: SerializedLambda = try {
        writeReplaceMethod.invoke(func) as SerializedLambda
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
        throw RuntimeException("无法调用writeReplace方法")
    } catch (e: InvocationTargetException) {
        e.printStackTrace()
        throw RuntimeException("无法调用writeReplace方法")
    }
    val methodName = serializedLambda.implMethodName
    val className = serializedLambda.implClass
    return Method(className, methodName)
}
