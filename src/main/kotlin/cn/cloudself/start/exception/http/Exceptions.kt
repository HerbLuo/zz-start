package cn.cloudself.start.exception.http

import java.lang.RuntimeException

const val BAD_REQUEST = "Bad Request"
const val NOT_FIND = "Not Found"
const val UNAUTHORIZED = "Unauthorized"
const val SERVER_ERROR = "Server Error"

typealias MessageGenerator = () -> String

open class HttpException(
    open val code: Int,
    open val alert: String?,
    message: MessageGenerator,
): RuntimeException(message())

class RequestBadException(
    override val alert: String? = null,
    override val code: Int = 0x1000,
    message: MessageGenerator = { BAD_REQUEST },
): HttpException(code, alert, message)

class RequestNotFindException(
    override val alert: String? = null,
    override val code: Int = 0x1100,
    message: MessageGenerator = { NOT_FIND },
): HttpException(code, alert, message)

class RequestTooLargeException(
    override val alert: String? = null,
    override val code: Int = 0x1200,
    message: MessageGenerator = { BAD_REQUEST },
): HttpException(code, alert, message)

class RequestTooManyException(
    override val alert: String? = null,
    override val code: Int = 0x1300,
    message: MessageGenerator = { BAD_REQUEST },
): HttpException(code, alert, message)

class RequestUnauthorizedException(
    override val alert: String? = null,
    override val code: Int = 0x1400,
    message: MessageGenerator = { UNAUTHORIZED },
): HttpException(code, alert, message)

class ServerException(
    override val alert: String? = null,
    override val code: Int = 0x1500,
    message: MessageGenerator = { SERVER_ERROR },
): HttpException(code, alert, message)

class ServerNotImplementedException(
    override val alert: String? = null,
    override val code: Int = 0x1600,
    message: MessageGenerator = { SERVER_ERROR },
): HttpException(code, alert, message)

class ServerUnavailableException(
    override val alert: String? = null,
    override val code: Int = 0x1700,
    message: MessageGenerator = { SERVER_ERROR },
): HttpException(code, alert, message)
