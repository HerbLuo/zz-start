package cn.cloudself.start.components

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.support.JdbcTransactionManager
import javax.annotation.Resource
import javax.sql.DataSource

@Configuration
class MyBeans {
    @Resource
    private lateinit var dataSource: DataSource

    @Bean
    fun transactionManager() = JdbcTransactionManager(dataSource)
}
