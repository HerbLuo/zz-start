package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.SysQueryDataReq
import cn.cloudself.start.service.ISysQueryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Api(tags = ["查询方案"])
@RestController
@RequestMapping("/query")
class SysQueryController @Autowired constructor(
    private val query: ISysQueryService,
) {
    @ApiOperation(value = "获取默认的查询方案")
    @GetMapping("/{tag}")
    fun get(@PathVariable tag: String) = query.get(tag)

    @ApiOperation(value = "获取用户配置的查询方案或默认的查询方案")
    @GetMapping("/{pageTag}")
    fun getPlan(@PathVariable pageTag: String) = query.getPlan(pageTag)

    @LoginRequired(false)
    @ApiOperation(value = "使用查询方案查询")
    @PostMapping("/data")
    fun getData(@RequestBody query: SysQueryDataReq) = this.query.getData(query)
}
