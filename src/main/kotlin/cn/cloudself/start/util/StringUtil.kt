package cn.cloudself.start.util

object StringUtil {
    @JvmStatic
    @JvmOverloads
    fun CharSequence.areEscaped(currentI: Int, esc: Char = '\\'): Boolean {
        if (currentI == 0) return false
        var i = currentI - 1
        var count = 0
        while (i >= 0) {
            if (this[i--] == esc) {
                count++
            } else {
                break
            }
        }
        return (count % 2) == 1
    }

    @JvmStatic
    @JvmOverloads
    fun CharSequence.split(splitter: Char, esc: Char = '\\'): List<String> {
        val result = mutableListOf<String>()

        val builder = StringBuilder()

        var areEsc = false
        for (char in this) {
            if (areEsc) {
                builder.append(char)
                areEsc = false
                continue
            }
            if (char == esc) {
                builder.append(char)
                areEsc = true
                continue
            }
            if (char == splitter) {
                result.add(builder.toString())
                builder.clear()
                continue
            }
            builder.append(char)
        }

        result.add(builder.toString())
        return result
    }

    @JvmStatic
    @JvmOverloads
    fun CharSequence.unwrapEscapedChar(esc: Char = '\\'): String {
        val builder = StringBuilder()
        val len = this.length
        var i = 0
        while (i < len) {
            val char = this[i]
            if (char == esc) {
                i++
            }
            builder.append(this[i])
            i++
        }
        return builder.toString()
    }
}
