package cn.cloudself.start.components

import cn.cloudself.start.exception.http.*
import cn.cloudself.start.pojo.Res
import cn.cloudself.start.pojo.err
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletResponse

data class PlainError(
    val code: Int,
    val message: String?,
    val alert: String? = ""
)

val map = mapOf(
    RequestBadException::class.java to HttpStatus.BAD_REQUEST,
    RequestTooLargeException::class.java to HttpStatus.PAYLOAD_TOO_LARGE,
    RequestTooManyException::class.java to HttpStatus.TOO_MANY_REQUESTS,
    RequestUnauthorizedException::class.java to HttpStatus.UNAUTHORIZED,
    RequestNotFindException::class.java to HttpStatus.NOT_FOUND,
    ServerException::class.java to HttpStatus.INTERNAL_SERVER_ERROR,
    ServerNotImplementedException::class.java to HttpStatus.NOT_IMPLEMENTED,
    ServerUnavailableException::class.java to HttpStatus.SERVICE_UNAVAILABLE,
    HttpMediaTypeNotAcceptableException::class.java to HttpStatus.NOT_ACCEPTABLE,
    HttpMediaTypeNotSupportedException::class.java to HttpStatus.UNSUPPORTED_MEDIA_TYPE,
    HttpMessageNotReadableException::class.java to HttpStatus.BAD_REQUEST,
    HttpMessageNotWritableException::class.java to HttpStatus.INTERNAL_SERVER_ERROR,
    HttpRequestMethodNotSupportedException::class.java to HttpStatus.METHOD_NOT_ALLOWED,
    JWTVerificationException::class.java to HttpStatus.UNAUTHORIZED,
    JWTDecodeException::class.java to HttpStatus.UNAUTHORIZED
)

val logger = LoggerFactory.getLogger(ExceptionHandlerAdvice::class.java)!!

fun exHandler(ex: Exception) {
    if (ex is HttpException) {
        logger.error(
            "HttpException: code {}, message {}, alert {}, Exception handled in ExceptionHandlerAdvice {}",
            ex.code, ex.message, ex.alert, ex
        )
    } else {
        logger.error("Exception handled in ExceptionHandlerAdvice", ex)
    }
}

fun exceptionToPlainError(exception: Exception): Pair<HttpStatus, Res<PlainError>> {
    exHandler(exception)
    val status: HttpStatus = map[exception.javaClass] ?: HttpStatus.INTERNAL_SERVER_ERROR
    val pe = if (exception is HttpException) {
        PlainError(exception.code, exception.message, exception.alert)
    } else {
        PlainError(0x9000 + status.value(), exception.message)
    }
    return Pair(status, err(pe))
}

@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler
    fun exceptionAll(exception: Exception): ResponseEntity<Res<PlainError>> {
        val (status, body) = exceptionToPlainError(exception)
        return ResponseEntity(body, status)
    }
}

fun responseException(response: HttpServletResponse, exception: Exception) {
    val (status, body) = exceptionToPlainError(exception)
    response.status = status.value();
    response.outputStream.write(ObjectMapper().writeValueAsBytes(body))
}
