package cn.cloudself.start.interactive.res

import reactor.core.CoreSubscriber
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.core.publisher.Operators

class Async<T: Any> private constructor(): Flux<Any?>() {

    private var sink: FluxSink<Any>? = null
    private val onSinkLoadedList = mutableListOf<(FluxSink<Any>) -> Unit>()
    private val flux = create<Any?> {
        sink = it
        for (onSinkLoaded in onSinkLoadedList) {
            onSinkLoaded(it)
        }
    }

    class Promise<T> constructor()

    companion object {
        class PromiseCreator<T: Any>(private val async: Async<T>) {
            fun create(supplier: () -> T): Promise<T> {
                Thread {
                    val resolved = supplier()
                    async.sink?.next(resolved)
                }.start()
                return Promise()
            }
            fun <T> just(data: T): Promise<T> {
                return Promise()
            }
        }
        @JvmStatic
        fun <T: Any> create(customer: (PromiseCreator<T>) -> T): Async<T> {
            val async = Async<T>()
            val data = customer(PromiseCreator(async))
            val sink = async.sink
            if (sink == null) {
                async.onSinkLoadedList.add {
                    it.next(data)
                }
            } else {
                sink.next(data)
            }
            return async
        }
    }

    override fun subscribe(actual: CoreSubscriber<in Any?>) = flux.subscribe(actual)
}
