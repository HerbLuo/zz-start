package cn.cloudself.start.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["下拉列表"])
@RestController
@RequestMapping("/select-option/")
class SysSelectOptionController {

    @ApiOperation("使用key获取下拉列表", notes = "对应表sys_select_option")
    @GetMapping("/{key}")
    fun getByKey(@PathVariable key: String) {

    }
}
