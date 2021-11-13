package cn.cloudself.start.react.res

class Confirm constructor(
    private val confirm: String,
    private var okText: String,
    private val onOk: Function<*>,
    private var noText: String?,
    private var onNo: Function<*>?,
): ReactRes {
    constructor(confirm: String, onYes: Function<*>): this(confirm, "好", onYes, null, null)
    constructor(confirm: String, onYes: Function<*>, onNo: Function<*>?): this(confirm, "是", onYes, "否", onNo)

    override fun toRes(): Any {
        return Res(confirm)
    }

    data class Res (
        val confirm: String,
    )
}
