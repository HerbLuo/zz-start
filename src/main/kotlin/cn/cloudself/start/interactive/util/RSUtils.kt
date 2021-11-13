package cn.cloudself.start.interactive.util

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class RSUtils: ApplicationContextAware {

    companion object {
        private var applicationContext: ApplicationContext? = null
        private val logger = LoggerFactory.getLogger(RSUtils::class.java)

        @JvmStatic
        fun <T>getBean(beanType: Class<T>): T? {
            return try {
                applicationContext?.getBean(beanType)
            } catch (e: Exception) {
                logger.warn("获取bean失败: " + e.message)
                null
            }
        }

        @JvmStatic
        fun <T>getBean(name: String, clazz: Class<T>): T? {
            return try {
                applicationContext?.getBean(name, clazz)
            } catch (e: Exception) {
                logger.warn("获取bean失败: " + e.message)
                null
            }
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        RSUtils.applicationContext = applicationContext
    }
}