package cn.cloudself.start.annotation

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
annotation class LoginRequired(val required: Boolean = true)
