package cn.cloudself.start.interactive.res

import reactor.core.CoreSubscriber
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.core.publisher.Operators

class Async<T: Any> private constructor(
    private val init: (FluxSink<Any>) -> Unit
): Flux<Any?>() {

    private val flux = create<Any?> { init(it) }
    override fun subscribe(actual: CoreSubscriber<in Any?>) = flux.subscribe(actual)

    class Promise<T> constructor()

    companion object {
        open class PromiseCreator(private val sink: FluxSink<Any>) {
            internal val tasks = mutableListOf<() -> Unit>()

            fun <T: Any> create(supplier: () -> T): Promise<T> {
                tasks.add {
                    val resolved = supplier()
                    sink.next(resolved)
                }
                return Promise()
            }

            fun <T: Any> just(data: T): Promise<T> {
                tasks.add {
                    sink.next(data)
                }
                return Promise()
            }
        }

        /**
         * 创建一个Async
         * 参数是一个回调, 提供了PromiseCreator，可以用来创建Promise
         * @sample cn.cloudself.start.interactive.test.MyInteractiveTestServiceImpl.testAsync
         */
        @JvmStatic
        fun <T: Any> create(customer: (PromiseCreator) -> T): Async<T> {
            val async = Async<T> {
                val promiseCreator = PromiseCreator(it)
                val data = customer(promiseCreator)
                it.next(data)
                Thread {
                    for (task in promiseCreator.tasks) {
                        task()
                    }
                    it.complete()
                }.start()
            }
            return async
        }
    }
}
