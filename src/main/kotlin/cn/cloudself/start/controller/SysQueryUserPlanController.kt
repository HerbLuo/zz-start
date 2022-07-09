package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import cn.cloudself.start.pojo.SysQueryReq
import cn.cloudself.start.service.ISysQueryUserPlanService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["查询方案"])
@RestController
@RequestMapping("/query-user-plan")
class SysQueryUserPlanController @Autowired constructor(
    private val queryUserPlan: ISysQueryUserPlanService,
) {
    @ApiOperation(value = "获取用户配置的查询方案或默认的查询方案")
    @GetMapping("/{tag}")
    fun getPlan(@PathVariable tag: String) = queryUserPlan.getPlan(tag)

    @LoginRequired(false)
    @ApiOperation(value = "使用查询方案查询")
    @PostMapping("/query")
    fun getData(@RequestBody query: SysQueryReq) = queryUserPlan.getData(query)
}
