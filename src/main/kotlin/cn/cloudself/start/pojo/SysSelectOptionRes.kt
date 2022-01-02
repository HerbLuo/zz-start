package cn.cloudself.start.pojo

import io.swagger.annotations.ApiModel

@ApiModel(description = "下拉框")
data class SysSelectOptionRes(
    val label: String?,
    val value: String?,
    val default: Boolean = false,
    val payload: Map<String, Any?>? = null,
)
