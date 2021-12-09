package cn.cloudself.start.interactive

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * @author herbluo
 */
@Aspect
@Component
class AsyncAspect @Autowired constructor(
) {
    private val log = LoggerFactory.getLogger("AutoLog")

    @Pointcut("@annotation(cn.cloudself.start.annotation.AutoLog)||@within(cn.cloudself.start.annotation.AutoLog)")
    fun autoLog() {
    }

    @Before("autoLog()")
    fun logBefore(jp: JoinPoint) {
        val methodName = jp.signature.name
        val className = jp.target.javaClass.simpleName
        log.info(
            "The method {}.{} 's params are {}",
            className,
            methodName,
            jp.args
        )
    }

    @AfterReturning(pointcut = "autoLog()", returning = "returnVal")
    fun logAfter(jp: JoinPoint, returnVal: Any?) {
        log.info(
            "The result of method {} is [ {} ]",
            jp.signature.name,
            returnVal
        )
    }
}