package cn.cloudself.start.components

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.support.JdbcTransactionManager
import javax.sql.DataSource

@Configuration
class MyBeans {
    @Autowired
    private lateinit var dataSource: DataSource

    @Bean
    fun transactionManager() = JdbcTransactionManager(dataSource)
}
