package cn.cloudself.start.util

object ParseUtil {
    @JvmStatic
    fun areEscaped(chars: CharSequence, currentI: Int): Boolean {
        if (currentI == 0) return false
        var i = currentI - 1
        var count = 0
        while (i >= 0) {
            if (chars[i--] == '\\') {
                count++
            } else {
                break
            }
        }
        return (count % 2) == 1
    }
}
