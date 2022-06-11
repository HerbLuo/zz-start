package cn.cloudself.start.exception.http

import cn.cloudself.start.util.I18n
import cn.cloudself.start.util.StringTemplate
import org.springframework.http.HttpStatus

const val BAD_REQUEST = "Bad Request"
const val NOT_FIND = "Not Found"
const val UNAUTHORIZED = "Unauthorized"
const val SERVER_ERROR = "Server Error"

open class HttpException(
    val code: Int,
    val alert: String?,
    val status: HttpStatus,
    message: String,
    cause: Throwable?
): RuntimeException(message, cause)

class RequestBadException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1000, alert?.toString(), HttpStatus.BAD_REQUEST, message ?: BAD_REQUEST, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class RequestNotFindException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1100, alert?.toString(), HttpStatus.NOT_FOUND, message ?: NOT_FIND, cause) {
    constructor(): this(null, null, null, null)
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class RequestTooLargeException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1200, alert?.toString(), HttpStatus.PAYLOAD_TOO_LARGE, message ?: BAD_REQUEST, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class RequestTooManyException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1300, alert?.toString(), HttpStatus.TOO_MANY_REQUESTS, message ?: BAD_REQUEST, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class RequestUnauthorizedException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1400, alert?.toString(), HttpStatus.UNAUTHORIZED, message ?: UNAUTHORIZED, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class ServerException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1500, alert?.toString(), HttpStatus.INTERNAL_SERVER_ERROR, message ?: SERVER_ERROR, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class ServerNotImplementedException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1600, alert?.toString(), HttpStatus.NOT_IMPLEMENTED, message ?: SERVER_ERROR, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}

class ServerUnavailableException(
    alert: I18n?, code: Int?, message: String?, cause: Throwable?
): HttpException(code ?: 0x1700, alert?.toString(), HttpStatus.SERVICE_UNAVAILABLE, message ?: SERVER_ERROR, cause) {
    constructor(alert: I18n): this(alert, alert.getId(), null, null)
    constructor(alert: I18n, message: String, vararg args: Any?) : this(alert, alert.getId(), StringTemplate.of(message, *args), null)
    constructor(message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, *args), null)
    constructor(cause: Throwable, message: String, vararg args: Any?): this(null, null, StringTemplate.of(message, args), cause)
}
