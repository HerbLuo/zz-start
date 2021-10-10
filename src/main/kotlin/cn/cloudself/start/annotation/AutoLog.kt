package cn.cloudself.start.annotation

/**
 * 在类或方法上加会自动记录入参及返回值
 * @author herbluo
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
annotation class AutoLog
