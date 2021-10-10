package cn.cloudself.start.controller

import cn.cloudself.start.pojo.Res
import cn.cloudself.start.pojo.ok
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/db")
class DbController @Autowired constructor(
) {
    private val log = LoggerFactory.getLogger(DbController::class.java)

    @GetMapping("/test")
    fun test(): Res<String> {
        log.warn("测试123")
        return ok("done")
    }
}
