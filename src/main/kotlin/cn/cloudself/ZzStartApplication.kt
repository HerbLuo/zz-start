package cn.cloudself

import cn.cloudself.query.QueryProConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZzStartApplication

fun main(args: Array<String>) {
    QueryProConfig.global.setLogicDelete(true)

    runApplication<ZzStartApplication>(*args)
}
