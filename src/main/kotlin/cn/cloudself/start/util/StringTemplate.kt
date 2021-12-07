package cn.cloudself.start.util

import java.text.SimpleDateFormat
import java.util.*

object StringTemplate {
    private var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @JvmStatic
    fun setDateFormat(pattern: String) {
        dateFormat = SimpleDateFormat(pattern)
    }

    /**
     * String.of("hello {}, today is {}", "dd", Date())
     * String.of("hello {}, I want to print \{}", "dd")
     */
    @JvmStatic
    fun of(template: CharSequence, vararg args: Any?): String {
        val resBuilder = StringBuilder()
        var argI = 0

        val argsSize = args.size
        val length = template.length
        var i = 0
        while (i < length) {
            when (val char = template[i++]) {
                '\\' -> {
                    resBuilder.append(template[i++])
                }
                '{' -> {
                    val nextChar = template[i++]
                    if (nextChar == '}') {
                        if (argI < argsSize) {
                            val arg = args[argI++]
                            appendObj(resBuilder, arg)
                        }
                    } else {
                        resBuilder.append(char)
                        resBuilder.append(nextChar)
                    }
                }
                else -> {
                    resBuilder.append(char)
                }
            }
        }

        return resBuilder.toString()
    }

    private fun appendObj(builder: StringBuilder, obj: Any?) {
        fun appendIter(iter: Iterator<*>) {
            var areFirst = true
            for (item in iter) {
                if (!areFirst) {
                    builder.append(", ")
                }
                areFirst = false
                appendObj(builder, item)
            }
        }
        when (obj) {
            is Date -> {
                builder.append(dateFormat.format(obj))
            }
            is Array<*> -> {
                builder.append('[')
                appendIter(obj.iterator())
                builder.append(']')
            }
            is List<*> -> {
                builder.append('<')
                appendIter(obj.iterator())
                builder.append('>')
            }
            is Iterable<*> -> {
                builder.append('{')
                appendIter(obj.iterator())
                builder.append('}')
            }
            is Map<*, *> -> {
                builder.append('{')
                appendIter(obj.iterator())
                builder.append('}')
            }
            is Map.Entry<*, *> -> {
                appendObj(builder, obj.key)
                builder.append('=')
                appendObj(builder, obj.value)
            }
            else -> {
                builder.append(obj.toString())
            }
        }
    }
}
