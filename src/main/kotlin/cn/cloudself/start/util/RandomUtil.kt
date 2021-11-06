package cn.cloudself.start.util

import cn.cloudself.query.exception.UnSupportException
import java.util.Random
import kotlin.math.ceil
import kotlin.math.pow

object RandomUtil {
    @JvmStatic
    @JvmOverloads
    fun nextInt(len: Int = 3): Int {
        if (len > 9) {
            throw UnSupportException("不支持的长度, RandomUtil.nextInt最大长度为9")
        }
        return Random().nextInt(POWERS_OF_10[len])
    }

    @JvmStatic
    @JvmOverloads
    fun nextStr(len: Int = 3, upperCase: Boolean = true): String {
        val hex10 = (Math.random() * (36.0.pow(len) + 1)).toLong()
        val hex36 = hex10.toString(36).padStart(len, '0')
        return if (upperCase) hex36.uppercase() else hex36
    }

    /**
     * 去除了IlO0等容易错认的随机字符串，以及4
     */
    @JvmStatic
    @JvmOverloads
    fun nextGoodStr(len: Int = 3, upperCase: Boolean = true) = nextStr(len, upperCase).replace(badStrRegex, "8")

    /**
     * 一种正态分布(0-1范围内)
     */
    @JvmStatic
    fun normalRandom(): Double {
        /* 均值0，标准差1 */
        val gaussian = Random().nextGaussian()
        /* 均值0.5 标准差0.5 */
        return gaussian * 0.5 + 0.5
    }

    fun nextId(len: Int = 16, vararg withSymbols: Char): String {
        val loopTimes = ceil(len.toDouble() / 4).toInt()

        val idBuilder = StringBuilder()

        for (i in 1..loopTimes) {
            ss4(idBuilder, withSymbols)
        }

        return idBuilder.substring(0, len).toString()
    }

    private fun ss4(sb: StringBuilder, withSymbols: CharArray) {
        val randomNum = ((Math.random() + 1) * ((CHARSET62.size + withSymbols.size).toDouble().pow(4) - 1)).toLong()

        val ss4Reversed = baseXXEncodeReversed(randomNum, *withSymbols)
        for (c in 0 until ss4Reversed.size - 1) {
            sb.append(ss4Reversed[c])
        }
    }

    fun base64Encode(num: Long): String {
        return baseXXEncodeReversed(num, '_', '-').also { println(it) }.reversed().joinToString("")
    }

    /**
     * 给Int进行 baseXX编码
     * XX = 62 + withSymbols.size
     */
    private fun baseXXEncodeReversed(num: Long, vararg withSymbols: Char): MutableList<Char> {
        if (num == 0L) {
            return mutableListOf(CHARSET62[0])
        }

        val charset62len = CHARSET62.size
        val otherSymbolsLen = withSymbols.size
        val totalLen = charset62len + otherSymbolsLen

        var remainder = num
        val chars = mutableListOf<Char>()
        while (remainder > 0) {
            val index = (remainder % totalLen).toInt()
            if (index < charset62len) {
                chars.add(CHARSET62[index])
            } else {
                chars.add(withSymbols[index - charset62len])
            }
            remainder /= totalLen
        }
        return chars
    }

    private val badStrRegex = "[IlO04]".toRegex()
    private val POWERS_OF_10: Array<Int> = arrayOf(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000)
    private val CHARSET62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
}
