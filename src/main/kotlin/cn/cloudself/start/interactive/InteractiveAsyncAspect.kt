package cn.cloudself.start.interactive

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Aspect
@Component
class InteractiveAsyncAspect @Autowired constructor(
) {

    @Pointcut("@annotation(cn.cloudself.start.interactive.res.Async)||@within(cn.cloudself.start.interactive.res.Async)")
    fun async() {
    }

    @AfterReturning(pointcut = "async()", returning = "returnVal")
    fun asyncAfter(jp: JoinPoint, returnVal: Any?) {

    }
}