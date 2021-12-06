package cn.cloudself.util_test

import cn.cloudself.start.util.ParseUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ParseUtilTest {
    @Test
    fun test() {
        assertFalse(ParseUtil.areEscaped("n", 0))
        assertTrue(ParseUtil.areEscaped("""\n""", 1))
        assertFalse(ParseUtil.areEscaped("""\\n""", 2))
        assertFalse(ParseUtil.areEscaped("""\nn""", 2))
        assertTrue(ParseUtil.areEscaped("""\\\n""", 3))
        assertFalse(ParseUtil.areEscaped("""\\\n""", 4))
        println("test ok")
    }
}

