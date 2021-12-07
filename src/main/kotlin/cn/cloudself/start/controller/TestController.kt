package cn.cloudself.start.controller

import cn.cloudself.start.annotation.LoginRequired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RequestMapping("/test")
@RestController
class TestController {

    @LoginRequired(false)
    @GetMapping("/foo")
    fun foo(): Mono<Boolean> {
        return Mono.just(true)
    }

    @LoginRequired(false)
    @GetMapping("/foo3", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
//    @GetMapping("/foo3")
    fun foo3(): Flux<Long> {
        return Flux.fromArray(arrayOf(1, 2, 3, 5))
//        Flux.interval(Duration.ofSeconds(5))
    }

    @LoginRequired(false)
    @GetMapping("/foo2")
    fun foo2(): String {
        return "success"
    }

    @LoginRequired(false)
    @GetMapping("/foo4")
    fun foo4(): Boolean {
        return true
    }
}
