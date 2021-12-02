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
    fun foo2(): Flux<Long> {
        return Flux.interval(Duration.ofSeconds(1))
    }
}
