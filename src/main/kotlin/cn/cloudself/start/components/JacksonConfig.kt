package cn.cloudself.start.components

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat
import java.util.*

@Configuration
class JacksonConfig {
    @Bean
    fun configJackson() = Jackson2ObjectMapperBuilderCustomizer {
            it
                .timeZone(TimeZone.getDefault())
                .dateFormat(SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .serializationInclusion(JsonInclude.Include.NON_NULL)
    }
}
