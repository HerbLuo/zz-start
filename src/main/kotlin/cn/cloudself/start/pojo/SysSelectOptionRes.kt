package cn.cloudself.start.pojo

data class SysSelectOptionRes(
    val label: String?,
    val value: String?,
    val default: Boolean = false,
    val payload: Map<String, Any?>? = null,
)
