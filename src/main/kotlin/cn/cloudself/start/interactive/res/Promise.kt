package cn.cloudself.start.interactive.res

data class Promise<T>(
    val url: String?,
    val data: T?,
    val type: String,
) {
    companion object {
        private const val PROMISE_OBJECT_WITH_URL = "#Promise##ObJ#with#url"
        private const val PROMISE_OBJECT_WITH_RESOLVED_DATA = "#Promise##ObJ#with#resolved#data"

        @JvmStatic
        fun <T> create(func: () -> T): Promise<T> {
            Runnable {
                val res = func()
            }

            return Promise("TODO ", null, PROMISE_OBJECT_WITH_URL)
        }
        @JvmStatic
        fun <T> resolve(data: T): Promise<T> {
            return Promise(null, data, PROMISE_OBJECT_WITH_RESOLVED_DATA)
        }
    }
}

annotation class Async {
}
