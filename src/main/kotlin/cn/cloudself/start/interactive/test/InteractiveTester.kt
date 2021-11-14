package cn.cloudself.start.interactive.test

import cn.cloudself.start.interactive.res.Confirm
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/zz/test/interactive/")
class MyInteractiveTestController @Autowired constructor(
    private val testService: IMyInteractiveTestService
) {
    @GetMapping("/confirm")
    fun testConfirm() = testService.testConfirm()
}

interface IMyInteractiveTestService {
    fun testConfirm(): Confirm
    fun deleteById(id: Long): String
}

@Service
class MyInteractiveTestServiceImpl: IMyInteractiveTestService {
    override fun testConfirm() = Confirm(
        "确认删除",
        onOk = IMyInteractiveTestService::deleteById,
        onNo = null
    )

    override fun deleteById(id: Long) = "已删除, id: $id"
}
