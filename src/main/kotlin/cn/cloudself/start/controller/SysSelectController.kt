package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.SysSelectDataReq
import cn.cloudself.start.service.ISysSelectService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["查询方案"])
@RestController
@RequestMapping("/select")
class SysSelectController @Autowired constructor(
    private val selectService: ISysSelectService,
) {
    @ApiOperation(value = "获取默认的查询方案")
    @GetMapping("/{tag}")
    fun get(@PathVariable tag: String) = selectService.get(tag)

    @ApiOperation(value = "获取用户配置的查询方案或默认的查询方案")
    @GetMapping("/{pageTag}")
    fun getPlan(@PathVariable pageTag: String) = selectService.getPlan(pageTag)

    @LoginRequired(false)
    @ApiOperation(value = "使用查询方案查询")
    @PostMapping("/data")
    fun getData(@RequestBody query: SysSelectDataReq) = this.selectService.getData(query)
}
