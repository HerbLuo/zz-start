//package cn.cloudself.start.interactive
//
//import org.aspectj.lang.ProceedingJoinPoint
//import org.aspectj.lang.annotation.Around
//import org.aspectj.lang.annotation.Aspect
//import org.aspectj.lang.annotation.Pointcut
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Component
//import reactor.core.publisher.Flux
//
//@Aspect
//@Component
//class InteractiveAsyncAspect @Autowired constructor(
//) {
//
//    @Pointcut("@annotation(cn.cloudself.start.interactive.res.Async)||@within(cn.cloudself.start.interactive.res.Async)")
//    fun async() {
//    }
//
//    @Around("async()")
//    fun asyncAfter(jp: ProceedingJoinPoint): Flux<Any?> {
//        return Flux.create {
//            it.next(jp.proceed()!!)
//            it.next(123)
//            it.complete()
//        }
//    }
//}