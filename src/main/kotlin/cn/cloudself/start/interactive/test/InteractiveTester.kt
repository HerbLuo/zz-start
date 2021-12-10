package cn.cloudself.start.interactive.test

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.interactive.res.Async
import cn.cloudself.start.interactive.res.Confirm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
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

    @LoginRequired(false)
    @GetMapping("/async", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun testPromise() = testService.testAsync()
}

interface IMyInteractiveTestService {
    fun testConfirm(): Confirm
    fun deleteById(id: Long): String

    fun testAsync(): Async<Obj>
}

data class Obj(
    val k1: String,
    val k2: Async.Promise<String>,
)

@Service
class MyInteractiveTestServiceImpl: IMyInteractiveTestService {
    override fun testConfirm() = Confirm(
        "确认删除",
        onOk = IMyInteractiveTestService::deleteById,
        onNo = null
    )

    override fun deleteById(id: Long) = "已删除, id: $id"

    override fun testAsync(): Async<Obj> {
        return Async.create {
            Obj("123", it.create { "567" })
        }
    }
}
