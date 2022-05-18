package cn.cloudself.start.util

import cn.cloudself.query.exception.IllegalCall
import cn.cloudself.start.exception.UnSupportException
import cn.cloudself.start.exception.http.HttpException
import org.graalvm.polyglot.Value
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.function.Predicate
import javax.script.ScriptEngineManager
import javax.script.ScriptException

object ScriptUtil {
    private val log = LoggerFactory.getLogger(ScriptUtil::class.java)

    init {
        System.setProperty("polyglot.engine.WarnInterpreterOnly", "false")
    }

    private val engine = ScriptEngineManager().getEngineByName("javascript")
    private val func = ScriptUtilFunc()
    private val scriptMethodNames = ScriptUtilFunc::class.java.declaredMethods.map { it.name }
    private val reservedVarNames = scriptMethodNames + arrayOf("zz_java_func", "polyglot")
    private val scriptHelper = scriptMethodNames.joinToString { "const $it=s=>zz_java_func.$it(s);" }

    @JvmOverloads
    fun eval(script: String, vars: Map<String, Any?>? = null): Any {
        if (vars != null) {
            for (reservedVarName in reservedVarNames) {
                if (vars.containsKey(reservedVarName)) {
                    throw UnSupportException("{} 是我们保留的变量名, 不可用于eval时候的参数")
                }
            }
        }

        val bindings = engine.createBindings()
        if (vars != null) {
            bindings.putAll(vars)
        }
        bindings["polyglot.js.allowHostAccess"] = true
        bindings["polyglot.js.allowHostClassLookup"] = Predicate { _: String? -> true }
        bindings["zz_java_func"] = func

        val finalScript = scriptHelper + script
        println(finalScript)

        val obj = try {
            engine.eval(finalScript, bindings)
        } catch (e: ScriptException) {
            val cause = e.cause
            if (cause is HttpException) {
                throw cause
            }
            log.warn("JS 脚本配置错误", e)
            throw IllegalCall("JS 脚本配置错误, 无法运行JS, {}", e.message)
        }
        return formatObject(obj)
    }

    private fun formatObject(obj: Any): Any {
        val value = Value.asValue(obj)
        var date: LocalDate? = null
        var time: LocalTime? = null
        if (value.isDate) {
            date = value.asDate()
        }
        if (value.isTime) {
            time = value.asTime()
        }
        return if (date != null) {
            if (time != null) {
                LocalDateTime.of(date, time)
            } else date
        } else time ?: obj
    }
}