package cn.cloudself

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ZzStartApplicationTests {
    @Test
    fun contextLoads() {
        val x = 1L
        x.toString(1)
    }
}
