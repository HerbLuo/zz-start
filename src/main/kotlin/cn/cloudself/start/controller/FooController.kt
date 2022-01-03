package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.Foo
import cn.cloudself.start.pojo.Token
import cn.cloudself.start.pojo.UsernamePassword
import cn.cloudself.start.service.ISysAuthService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/foo")
class FooController @Autowired constructor(
    private val authService: ISysAuthService
) {

    @PostMapping("/foo")
    fun foo(@RequestBody test: Foo): String {
        return "s";
    }
}
