package cn.cloudself.util_test

import cn.cloudself.start.util.StringUtil.areEscaped
import cn.cloudself.start.util.StringUtil.split
//import cn.cloudself.start.util.StringUtil.split
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringUtilTest {
    @Test
    fun testAreEscaped() {
        assertFalse("n".areEscaped(0))
        assertTrue ("""\n""".areEscaped(1))
        assertFalse("""\\n""".areEscaped(2))
        assertFalse("""\nn""".areEscaped(2))
        assertTrue ("""\\\n""".areEscaped(3))
        assertFalse("""\\\n""".areEscaped(4))
        println("test ok")
    }

    @Test
    fun testSplit() {
        "a ab abc abc\\ d".split(' ')
            .also {
                println(it)
                assertTrue(it.size == 4)
                assertTrue(it.last() == "abc\\ d")
            }
    }
}

