package cn.cloudself.start.exception.http

import cn.cloudself.start.util.I18n
import java.lang.RuntimeException

//typealias I18n = String

const val BAD_REQUEST = "Bad Request"
const val NOT_FIND = "Not Found"
const val UNAUTHORIZED = "Unauthorized"
const val SERVER_ERROR = "Server Error"

open class HttpException(
    val code: Int,
    val alert: String?,
    message: String,
): RuntimeException(message)

class RequestBadException(
    alert: I18n? = null,
    code: Int = 0x1000,
    message: String = BAD_REQUEST,
): HttpException(code, alert.toString(), message)

class RequestNotFindException(
    alert: I18n? = null,
    code: Int = 0x1100,
    message: String = NOT_FIND,
): HttpException(code, alert.toString(), message)

class RequestTooLargeException(
    alert: I18n? = null,
    code: Int = 0x1200,
    message: String = BAD_REQUEST,
): HttpException(code, alert.toString(), message)

class RequestTooManyException(
    alert: I18n? = null,
    code: Int = 0x1300,
    message: String = BAD_REQUEST,
): HttpException(code, alert.toString(), message)

class RequestUnauthorizedException(
    alert: I18n? = null,
    code: Int = 0x1400,
    message: String = UNAUTHORIZED,
): HttpException(code, alert.toString(), message)

class ServerException(
    alert: I18n? = null,
    code: Int = 0x1500,
    message: String = SERVER_ERROR,
): HttpException(code, alert.toString(), message)

class ServerNotImplementedException(
    alert: I18n? = null,
    code: Int = 0x1600,
    message: String = SERVER_ERROR,
): HttpException(code, alert.toString(), message)

class ServerUnavailableException(
    alert: I18n? = null,
    code: Int = 0x1700,
    message: String = SERVER_ERROR,
): HttpException(code, alert.toString(), message)
