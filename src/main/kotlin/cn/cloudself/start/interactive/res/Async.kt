
package cn.cloudself.start.interactive.res

import reactor.core.CoreSubscriber
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink

@Suppress("unused")
class Async<T: Any> private constructor(
    init: (FluxSink<Any>) -> Unit,
    promises: List<(FluxSink<Any>) -> Unit>
): Flux<Any?>() {

    private val flux = create<Any?> { sink ->
        init(sink)
        val threads = promises.map { promise ->
            Thread {
                promise(sink)
            }.also { it.start() }
        }
        Thread {
            for (thread in threads) {
                thread.join()
            }
            sink.complete()
        }.start()
    }

    override fun subscribe(actual: CoreSubscriber<in Any?>) = flux.subscribe(actual)

    data class Promise<T>(
        val id: String,
        val `it's a promise`: Boolean = true,
    )

    data class PromiseResolved<T>(
        val id: String,
        val resolved: T,
    )

    companion object {
        open class PromiseCreator {
            internal val tasks = mutableListOf<(FluxSink<Any>) -> Unit>()
            private var id = System.currentTimeMillis()

            fun <T: Any> create(supplier: () -> T): Promise<T> {
                val id = (id++).toString(36)
                tasks.add {
                    val resolved = supplier()
                    it.next(PromiseResolved(id, resolved))
                }
                return Promise(id)
            }

            fun <T: Any> just(data: T) = create { data }
        }

        /**
         * 创建一个Async
         * 参数是一个回调, 提供了PromiseCreator，可以用来创建Promise
         * @sample cn.cloudself.start.interactive.test.MyInteractiveTestServiceImpl.testAsync
         */
        @JvmStatic
        fun <T : Any> create(customer: (PromiseCreator) -> T): Async<T> {
            val promiseCreator = PromiseCreator()

            return Async(
                { it.next(customer(promiseCreator)) },
                promiseCreator.tasks
            )
        }
    }
}
