package cn.cloudself.start.components

import cn.cloudself.start.exception.http.*
import cn.cloudself.start.pojo.Res
import cn.cloudself.start.pojo.err
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

data class PlainError(
    val code: Int,
    val message: String?,
    val alert: String? = ""
)

val map = mapOf(
    RequestBadException::class.java as Class<out Throwable> to HttpStatus.BAD_REQUEST,
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
    JWTDecodeException::class.java to HttpStatus.UNAUTHORIZED,
    TokenExpiredException::class.java to HttpStatus.UNAUTHORIZED,
)

val logger = LoggerFactory.getLogger(ExceptionHandlerAdvice::class.java)!!

fun exHandler(ex: Throwable) {
    if (ex is HttpException) {
        logger.error(
            "HttpException: code {}, message {}, alert {}, Exception handled in ExceptionHandlerAdvice {}",
            ex.code, ex.message, ex.alert, ex
        )
    } else if (ex is JWTVerificationException) {
        logger.error("ex", ex)
    } else {
        logger.error("Exception handled in ExceptionHandlerAdvice", ex)
    }
}

fun exceptionToPlainError(throwable: Throwable): Pair<HttpStatus, Res<PlainError>> {
    exHandler(throwable)
    val status: HttpStatus = map[throwable.javaClass] ?: HttpStatus.INTERNAL_SERVER_ERROR
    val pe = if (throwable is HttpException) {
        PlainError(throwable.code, throwable.message, throwable.alert)
    } else {
        PlainError(0x9000 + status.value(), throwable.message)
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

@RestController
class ErrorPageController: ErrorController {
    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest, throwableOri: Throwable): ResponseEntity<Res<PlainError>> {
        val statusCodeMay = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        val throwable = if (statusCodeMay == 404) {
            RequestNotFindException()
        } else {
            throwableOri
        }
        val (status, body) = exceptionToPlainError(throwable)
        return ResponseEntity(body, status)
    }
}

fun responseException(response: HttpServletResponse, throwable: Throwable) {
    val (status, body) = exceptionToPlainError(throwable)
    response.status = status.value();
    response.outputStream.write(ObjectMapper().writeValueAsBytes(body))
    response.contentType = "application/json; charset=utf-8;"
}
