import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.ParameterBuilderPlugin
import springfox.documentation.spi.service.contexts.ParameterContext
import springfox.documentation.swagger.common.SwaggerPluginSupport

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
class SwaggerParametersPlugin : ParameterBuilderPlugin {

    override fun apply(parameterContext: ParameterContext) {
        val parameter = parameterContext.resolvedMethodParameter()
        val parameterType = parameter.parameterType
        if (parameterType.isArray) {
            val arrayElementType = parameterType.arrayElementType
            parameterContext.requestParameterBuilder()
                .description("type(" + arrayElementType.erasedType.simpleName + "[])")
        }
    }

    override fun supports(delimiter: DocumentationType): Boolean {
        return true
    }

}