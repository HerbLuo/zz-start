package cn.cloudself.start.components

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

import org.springframework.web.servlet.config.annotation.InterceptorRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AuthenticationConfig @Autowired constructor(
    private val authenticationInterceptor: AuthenticationInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**")
    }
}