import io.swagger.annotations.Api
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.OperationBuilderPlugin
import springfox.documentation.spi.service.contexts.OperationContext
import springfox.documentation.swagger.common.SwaggerPluginSupport

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
class SwaggerGroupInfoPlugin : OperationBuilderPlugin {

    override fun apply(context: OperationContext) {
        val apiAnnotationOpt = context.findControllerAnnotation(Api::class.java)
        val tags = apiAnnotationOpt.map { api -> api.tags }.orElse(arrayOf())
        context.operationBuilder().tags(setOf(*tags, "group(${context.groupName})"))
   }

    override fun supports(delimiter: DocumentationType): Boolean {
        return true
    }
}