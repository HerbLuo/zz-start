package cn.cloudself.start.interactive.res

import cn.cloudself.start.interactive.util.serialize
import cn.cloudself.start.interactive.util.toUrlPart
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.net.URL
import kotlin.reflect.KFunction

class Confirm constructor(
    private val confirm: String,
    private var okText: String,
    private val onOk: KFunction<*>,
    private var noText: String?,
    private var onNo: KFunction<*>?,
): ReactRes {
    constructor(confirm: String, onOk: KFunction<*>): this(confirm, "好", onOk, null, null)
    constructor(confirm: String, onOk: KFunction<*>, onNo: KFunction<*>?): this(confirm, "是", onOk, "否", onNo)

    /**
     * 这里将对应方法序列化之后，
     * 必须加密之后才能传到前端，防止前端篡改
     */
    override fun toRes(): Any {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        val url = URL(request.scheme, request.serverName, request.serverPort, request.contextPath).toString() + "/"
        val okUrl = url + toUrlPart(onOk.serialize())
        val noUrl = onNo.let { if (it == null) null else url + toUrlPart(it.serialize()) }
        return Res(confirm, okText, okUrl, noText, noUrl)
    }

    data class Res (
        val confirm: String,
        val okText: String,
        val okUrl: String,
        val noText: String?,
        val noUrl: String?,
    )
}
