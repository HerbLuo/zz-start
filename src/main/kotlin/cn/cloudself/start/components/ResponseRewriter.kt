package cn.cloudself.start.components

import cn.cloudself.start.pojo.Res
import cn.cloudself.start.pojo.ok
import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@Configuration
class ResponseConfig : WebMvcConfigurer {
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>?>) {
        converters.add(0, MappingJackson2HttpMessageConverter())
    }
}

@ControllerAdvice
class ResponseAdvice: ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        val packageName = returnType.declaringClass.`package`.name
        if (packageName == "cn.cloudself.start.controller" || packageName == "cn.cloudself.controller") {
            return true
        }
        return false
    }

    @ResponseBody
    override fun beforeBodyWrite(body: Any?, returnType: MethodParameter, selectedContentType: MediaType, selectedConverterType: Class<out HttpMessageConverter<*>>, request: ServerHttpRequest, response: ServerHttpResponse): Any? {
        if (body is Res<*>) {
            return body
        }
        if (body is ResponseEntity<*>) {
            return body
        }
        return ok(body)
    }
}
