package cn.cloudself.start.util

class I18n constructor(
    private val value: String,
    private val id: Int? = null
) {
    override fun toString(): String {
        return value
    }

    fun getId() = id
}

/**
 * 未完成
 *
 * 先从数据库找，
 *   找到 直接返回
 *   没有找到，从配置文件找，
 *     找到，写数据库，返回
 *     没有找到，写数据库，返回key
 */
fun i18n(key: String, vararg args: Any?): I18n {
    return I18n(StringTemplate.of(key, *args))
}
