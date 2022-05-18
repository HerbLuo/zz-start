package cn.cloudself.start.components

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

import org.springframework.web.servlet.config.annotation.InterceptorRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AuthenticationConfig @Autowired constructor(
    private val authenticationInterceptor: AuthenticationInterceptor
) : WebMvcConfigurer {
    @Value("\${cloudself.auth.exclude-patterns:}")
    private val excludePatterns: Array<String> = arrayOf()

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**")
            .excludePathPatterns("/favicon.ico", "/error", "/swagger-ui/**", "/swagger-resources/**", "/*/api-docs/**")
            .excludePathPatterns(*excludePatterns)
    }
}