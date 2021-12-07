package cn.cloudself.start.components

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class FluxReturnValueHandler constructor(
    private val handler: HandlerMethodReturnValueHandler
): HandlerMethodReturnValueHandler {
    override fun supportsReturnType(methodParamter: MethodParameter): Boolean {
        val method = methodParamter.method ?: return false
        val returnType = method.returnType
        return Flux::class.java.isAssignableFrom(returnType) && handler.supportsReturnType(methodParamter)
    }

    override fun handleReturnValue(
        returnValue: Any?,
        method: MethodParameter,
        mavContainer: ModelAndViewContainer,
        webRequest: NativeWebRequest
    ) {
        @Suppress("ReactiveStreamsUnusedPublisher") val mapped = when (returnValue) {
            is Flux<*> -> returnValue.map { ok(it) }
            else -> returnValue
        }

        handler.handleReturnValue(mapped, method, mavContainer, webRequest)
    }
}

@Configuration
class ResponseRewriterInitializingBean @Autowired constructor(
    private val adapter: RequestMappingHandlerAdapter,
): InitializingBean {
    override fun afterPropertiesSet() {
        val returnValueHandlers = mutableListOf(*(adapter.returnValueHandlers ?: return).toTypedArray())
        val responseBodyEmitterHandler = returnValueHandlers.find { it is ResponseBodyEmitterReturnValueHandler }
            ?: throw RuntimeException("unsupported Spring Configuration, no ResponseBodyEmitterReturnValueHandler found")
        returnValueHandlers.add(0, FluxReturnValueHandler(responseBodyEmitterHandler))
        adapter.returnValueHandlers = returnValueHandlers
    }
}

@ControllerAdvice
class ResponseAdvice: ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        val packageName = returnType.declaringClass.`package`.name
        if (packageName.startsWith("cn.cloudself.")) {
            return true
        }
        return false
    }

    override fun beforeBodyWrite(body: Any?, returnType: MethodParameter, selectedContentType: MediaType, selectedConverterType: Class<out HttpMessageConverter<*>>, request: ServerHttpRequest, response: ServerHttpResponse): Any? {
        if (body is Res<*>) {
            return body
        }
        if (body is ResponseEntity<*>) {
            return body
        }
        if (StringHttpMessageConverter::class.java.isAssignableFrom(selectedConverterType)) {
            response.headers.contentType = MediaType.APPLICATION_JSON
            return ObjectMapper().writeValueAsString(ok(body))
        }
        return ok(body)
    }
}
