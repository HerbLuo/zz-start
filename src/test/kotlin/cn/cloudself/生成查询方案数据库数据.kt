package cn.cloudself

import cn.cloudself.codegen.QueryConfigDbCreator
import org.springframework.boot.jdbc.DataSourceBuilder

fun main() {
    val dataSource = DataSourceBuilder.create()
        .url("jdbc:mysql://127.0.0.1:3306/zz_start?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&serverTimezone=GMT%2B8")
        .username("root")
        .password("123456")
        .build()

    QueryConfigDbCreator
        .dataSource(dataSource)
        .ofResources()
}
