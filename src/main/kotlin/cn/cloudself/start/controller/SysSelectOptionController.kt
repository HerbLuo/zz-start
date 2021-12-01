package cn.cloudself.start.controller

import cn.cloudself.start.pojo.SysSelectOptionRes
import cn.cloudself.start.service.ISysSelectOptionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["下拉列表"])
@RestController
@RequestMapping("/select-option/")
class SysSelectOptionController @Autowired constructor(
    private val selectOptionService: ISysSelectOptionService
) {

    @ApiOperation("使用key获取下拉列表", notes = "对应表sys_select_option")
    @GetMapping("/{key}")
    fun getByKey(@PathVariable key: String): List<SysSelectOptionRes> =
        selectOptionService.getSelectOptions(key)

    @ApiOperation("使用key获取下拉列表", notes = "对应表sys_select_option")
    @GetMapping("/table/{table}/label/{label}/value/{value}")
    fun getByTableLabelValue(@PathVariable table: String, @PathVariable label: String, @PathVariable value: String) =
        selectOptionService.getSelectOptions(table, label, value)
}
