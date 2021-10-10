package cn.cloudself.start.components

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2 {
    @Bean
    fun createRestApi(): Docket =
        Docket(DocumentationType.SWAGGER_2)
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
}
