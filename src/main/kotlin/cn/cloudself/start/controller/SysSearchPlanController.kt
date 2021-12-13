package cn.cloudself.start.controller

import cn.cloudself.start.pojo.SysSearchQueryReq
import cn.cloudself.start.service.ISysSearchPlanService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["查询方案"])
@RestController
@RequestMapping("/search-plan")
class SysSearchPlanController @Autowired constructor(
    private val searchPlanService: ISysSearchPlanService,
) {
    @ApiOperation(value = "获取用户配置的查询方案或默认的查询方案")
    @GetMapping("/{planName}")
    fun getPlan(@PathVariable planName: String) = searchPlanService.getPlan(planName)

    @ApiOperation(value = "使用查询方案查询")
    @GetMapping("/query")
    fun getData(@RequestBody query: SysSearchQueryReq) = searchPlanService.getData(query)
}
