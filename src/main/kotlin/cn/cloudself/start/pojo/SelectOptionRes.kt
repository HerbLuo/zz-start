package cn.cloudself.start.pojo

data class SelectOptionRes(
    val label: String?,
    val value: String?,
    val default: Boolean = false,
    val payload: Map<String, Any?>? = null,
)
