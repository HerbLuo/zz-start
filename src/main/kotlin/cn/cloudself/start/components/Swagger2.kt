package cn.cloudself.start.components

import SwaggerGroupInfoPlugin
import SwaggerParametersPlugin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@EnableOpenApi
@Configuration
class Swagger2 : WebMvcConfigurer {
    @Bean
    fun createRestApi(): Docket =
        Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .select()
            .apis(
                RequestHandlerSelectors.basePackage("cn.cloudself.start.controller")
            )
            .paths(PathSelectors.any())
            .build()

    private fun apiInfo(): ApiInfo =
        ApiInfoBuilder()
            .title("接口文档")
            .contact(Contact("herbluo", "https://cloudself.cn/", "im.hb@qq.com"))
            .version("1.0")
            .build()

    @Bean
    fun addGroupInfoToApiBean() = SwaggerGroupInfoPlugin()

    @Bean
    fun fixParameters() = SwaggerParametersPlugin()
}
