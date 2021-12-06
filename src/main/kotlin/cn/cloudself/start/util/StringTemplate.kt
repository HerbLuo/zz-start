package cn.cloudself.start.util

object StringTemplate {
    /**
     * String.of("hello {}, today is {}", "dd", Date())
     * String.of("hello {}, I want to print \{}", "dd")
     */
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
            else -> {
                builder.append(obj.toString())
            }
        }
    }
}
