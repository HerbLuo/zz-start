package cn.cloudself.util_test

import cn.cloudself.start.util.StringTemplate
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class StringTemplateTest {
    @Test
    fun test() {
        assertEquals(StringTemplate.of("hello ll").also { println(it) }, "hello ll")
        assertEquals(StringTemplate.of("hello {}", "ll").also { println(it) }, "hello ll")

        assertEquals(StringTemplate.of("""hello \\{}""", "ll").also { println(it) }, """hello \ll""")
        assertEquals(StringTemplate.of("""hello \\\\{}""", "ll").also { println(it) }, """hello \\ll""")
        assertEquals(StringTemplate.of("""hello \\\\\{}""").also { println(it) }, """hello \\{}""")
        assertEquals(StringTemplate.of("""hello \\\\\\{}""", "ll").also { println(it) }, """hello \\\ll""")
        assertEquals(StringTemplate.of("""\\\\{}""", "ll").also { println(it) }, """\\ll""")
        assertEquals(StringTemplate.of("hello {}, print \\{}", "ll").also { println(it) }, "hello ll, print {}")

        assertEquals(StringTemplate.of("hello {}, print {}", "ll", 1).also { println(it) }, "hello ll, print 1")
        assertEquals(StringTemplate.of("hello {}, print {}", "ll", true).also { println(it) }, "hello ll, print true")
        assertEquals(StringTemplate.of("hello {}, print {}", "ll", arrayOf(1, 2)).also { println(it) }, "hello ll, print [1, 2]")
        assertEquals(StringTemplate.of("hello {}, print {}", "ll", listOf(1, 2)).also { println(it) }, "hello ll, print <1, 2>")
//        assertEquals(StringTemplate.of("hello {}, print {}", "ll", mapOf("a" to 1, "b" to Date())).also { println(it) }, "hello ll, print [1, 2]")
        assertEquals(StringTemplate.of("hello {}, today is {}", "ll", Date()).also { println(it) }, "hello ll")
    }
}
