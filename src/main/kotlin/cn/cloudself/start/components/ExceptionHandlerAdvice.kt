package cn.cloudself.start.components

import cn.cloudself.start.exception.http.*
import cn.cloudself.start.util.RandomUtil
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
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
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.math.abs
import kotlin.reflect.KClass

data class PlainError(
    val serial: String,
    val code: Int,
    val message: String?,
    val alert: String? = ""
)

data class Parsed3rdException(
    val status: HttpStatus,
    val code: Int,
    val message: String?,
    val alert: String? = "",
)

fun simpleParser(code: Int, eClass: KClass<out Throwable>, status: HttpStatus) =
    { e: Throwable -> if (eClass.isInstance(e)) Parsed3rdException(status, code, e.message) else null }

val throwableParsers = arrayOf(
    simpleParser(0xB001, HttpMediaTypeNotAcceptableException::class, HttpStatus.NOT_ACCEPTABLE),
    simpleParser(0xB002, HttpMediaTypeNotSupportedException::class, HttpStatus.UNSUPPORTED_MEDIA_TYPE),
    simpleParser(0xB003, HttpMessageNotReadableException::class, HttpStatus.BAD_REQUEST),
    simpleParser(0xB004, HttpMessageNotWritableException::class, HttpStatus.INTERNAL_SERVER_ERROR),
    simpleParser(0xB005, HttpRequestMethodNotSupportedException::class, HttpStatus.METHOD_NOT_ALLOWED),
    simpleParser(0xB006, JWTVerificationException::class, HttpStatus.UNAUTHORIZED),
    simpleParser(0xB007, JWTDecodeException::class, HttpStatus.UNAUTHORIZED),
    simpleParser(0xB008, TokenExpiredException::class, HttpStatus.UNAUTHORIZED),
    {
        if (it is HttpMessageNotReadableException) {
            val e = it.rootCause
            if (e is MissingKotlinParameterException) {
                return@arrayOf Parsed3rdException(HttpStatus.BAD_REQUEST, 0xA001, e.message)
            }
        }
        return@arrayOf null
    }
)

val logger = LoggerFactory.getLogger(ExceptionHandlerAdvice::class.java)!!

fun getRequestInfo(): String? {
    val attributes = RequestContextHolder.currentRequestAttributes()
    if (attributes is ServletRequestAttributes) {
        val requestInfoBuilder = StringBuilder("[")

        val request = attributes.request
        val forwardOriginUri = request.getAttribute("javax.servlet.forward.request_uri")
        if (forwardOriginUri != null) {
            requestInfoBuilder.append("origin uri: ", forwardOriginUri.toString(), ", ")
        }
        requestInfoBuilder.append("host: ", request.remoteHost, ", ")
        requestInfoBuilder.append("uri: ", request.requestURI.toString(), ", ")
        requestInfoBuilder.append("parameters: ")
        for ((key, values) in request.parameterMap.entries) {
            requestInfoBuilder.append("<", key, ":")
            if (values.size == 1) {
                requestInfoBuilder.append(values[0])
            } else {
                for (value in values) {
                    requestInfoBuilder.append(value, ",")
                }
            }
            requestInfoBuilder.append(">, ")
        }
        requestInfoBuilder.append(", ")
        requestInfoBuilder.append("headers: ")
        for (headerName in request.headerNames) {
            requestInfoBuilder.append("<", headerName, ":")
            val headers = request.getHeaders(headerName)
            var first = true
            for (header in headers) {
                if (!first) {
                    requestInfoBuilder.append(", ")
                }
                requestInfoBuilder.append(header)
                first = false
            }
            requestInfoBuilder.append(">, ")
        }
        requestInfoBuilder.append(']')
        return requestInfoBuilder.toString()
    }
    return null
}

fun exceptionToPlainError(e: Throwable): Pair<HttpStatus, Res<PlainError>> {
    val serial = RandomUtil.base64Encode(System.currentTimeMillis()) + ":" +
            RandomUtil.base64Encode(abs(Random().nextLong()))
    val requestInfo = getRequestInfo()
    val (pe, status) = when (e) {
        is HttpException -> {
            val pe = PlainError(serial, e.code, e.message, e.alert)
            pe to e.status
        }
        else -> {
            var parsed: Parsed3rdException? = null
            for (parser in throwableParsers) {
                parsed = parser(e)
                if (parsed != null) {
                    break
                }
            }
            if (parsed == null) {
                PlainError(serial, 0xFFFF, e.message) to HttpStatus.INTERNAL_SERVER_ERROR
            } else {
                PlainError(serial, parsed.code, parsed.message, parsed.alert) to parsed.status
            }
        }
    }
    logger.error(
        "Exception handled in ExceptionHandlerAdvice, serial: {}, code: {}, message: {}, alert: {}, req: {}, e: {}",
        serial, pe.code, pe.message, pe.alert, requestInfo, e
    )
    return Pair(status, err(pe))
}

@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler
    fun handleAll(exception: Exception): ResponseEntity<Res<PlainError>> {
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
    response.status = status.value()
    response.outputStream.write(ObjectMapper().writeValueAsBytes(body))
    response.contentType = "application/json; charset=utf-8;"
}
