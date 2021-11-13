package cn.cloudself.start.controller

import cn.cloudself.start.service.IConfirmTestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/confirm")
class ConfirmTestController @Autowired constructor(
    private val confirmTest: IConfirmTestService,
) {
    @GetMapping("/foo")
    fun test() = confirmTest.testConfirm()
}