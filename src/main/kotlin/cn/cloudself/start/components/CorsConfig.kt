package cn.cloudself.start.components

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author HerbLuo
 * @version 1.0.0.d
 *
 * change logs:
 * 2017/11/7 HerbLuo 首次创建
 */
@Configuration
class CorsConfig @Autowired constructor(
    private val env: Environment,
    @Value("\${cloudself.site.cors-allowed-origin:}") private val prodSites: Array<String>,
) : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        super.addCorsMappings(registry)
        val areProd = env.activeProfiles[0] == "prod"

        registry.addMapping("/**")
                .allowedOriginPatterns(*if(areProd) { prodSites } else { arrayOf("*") })
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
    }
}
