package cn.cloudself.start.interactive.res

import reactor.core.CoreSubscriber
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.core.publisher.Operators

class Async<T: Any> private constructor(
): Flux<Any?>() {
    private val flux = Flux.create<Any?> {  }
    private var sink: FluxSink<Any?>

    class Promise<T> constructor()

    companion object {
        class PromiseCreator {
            fun <T> create(supplier: () -> T): Promise<T> {
                return Promise()
            }
            fun <T> just(data: T): Promise<T> {
                return Promise()
            }
        }
        @JvmStatic
        fun <T: Any> create(customer: (PromiseCreator) -> T): Async<T> {
            var sink: FluxSink<Any?>

            Flux.from {}
        }
    }

    override fun subscribe(actual: CoreSubscriber<in Any?>) {
        flux.subscribe { it }
        actual.onSubscribe(Operators.scalarSubscription<T>(actual, data))
    }

    init {
        sink = Flux.generate<> {  }

    }
}
