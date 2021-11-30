package cn.cloudself.start.exception.http

import java.lang.RuntimeException

const val BAD_REQUEST = "Bad Request"
const val NOT_FIND = "Not Found"
const val UNAUTHORIZED = "Unauthorized"
const val SERVER_ERROR = "Server Error"

open class HttpException(
    open val code: Int,
    override val message: String,
    open val alert: String?
): RuntimeException(message)

class RequestBadException(
    override val alert: String? = null,
    override val code: Int = 0x1000,
    override val message: String = BAD_REQUEST,
): HttpException(code, BAD_REQUEST, alert)

class RequestNotFindException(
    override val alert: String? = null,
    override val code: Int = 0x1100,
    override val message: String = NOT_FIND,
): HttpException(code, NOT_FIND, alert)

class RequestTooLargeException(
    override val alert: String? = null,
    override val code: Int = 0x1200,
    override val message: String = BAD_REQUEST,
): HttpException(code, BAD_REQUEST, alert)

class RequestTooManyException(
    override val alert: String? = null,
    override val code: Int = 0x1300,
    override val message: String = BAD_REQUEST,
): HttpException(code, BAD_REQUEST, alert)

class RequestUnauthorizedException(
    override val alert: String? = null,
    override val code: Int = 0x1400,
    override val message: String = UNAUTHORIZED,
): HttpException(code, UNAUTHORIZED, alert)

class ServerException(
    override val alert: String? = null,
    override val code: Int = 0x1500,
    override val message: String = SERVER_ERROR,
): HttpException(code, SERVER_ERROR, alert)

class ServerNotImplementedException(
    override val alert: String? = null,
    override val code: Int = 0x1600,
    override val message: String = SERVER_ERROR,
): HttpException(code, SERVER_ERROR, alert)

class ServerUnavailableException(
    override val alert: String? = null,
    override val code: Int = 0x1700,
    override val message: String = SERVER_ERROR,
): HttpException(code, SERVER_ERROR, alert)
