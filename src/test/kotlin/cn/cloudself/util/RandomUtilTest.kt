package cn.cloudself.util

import cn.cloudself.start.util.RandomUtil
import org.junit.jupiter.api.Test
import java.util.*

class RandomUtilTest {
    @Test
    fun test() {
        for (i in 1..10) {
            RandomUtil.nextId(15).also { println("${it.length} $it") }
            RandomUtil.nextId(16).also { println("${it.length} $it") }
            RandomUtil.nextId(32).also { println("${it.length} $it") }
            RandomUtil.nextId(64).also { println("${it.length} $it") }
            RandomUtil.nextId(128).also { println("${it.length} $it") }
        }
    }

    @Test
    fun serial() {
        val serial = RandomUtil.base64Encode(System.currentTimeMillis()) + ":" + RandomUtil.base64Encode(Random().nextLong(
            Long.MAX_VALUE
        ))
        println(serial)
    }
}
