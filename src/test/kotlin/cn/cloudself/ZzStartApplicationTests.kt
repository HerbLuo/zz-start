package cn.cloudself

import cn.cloudself.start.service.ITestService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ZzStartApplicationTests {

    @Autowired
    private lateinit var testService: ITestService;

    @Test
    fun contextLoads() {
        testService.test();
    }

}
