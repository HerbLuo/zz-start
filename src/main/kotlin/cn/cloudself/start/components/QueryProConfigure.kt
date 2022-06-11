package cn.cloudself.start.components

import cn.cloudself.query.QueryProConfig
import cn.cloudself.query.SKIP
import cn.cloudself.start.util.WebUtil.getUser
import org.springframework.context.annotation.Configuration
import java.util.*

/**
 * QueryPro设置
 */
@Configuration
class QueryProConfigure {
    init {
        QueryProConfig.global.lifecycle()
            .beforeInsert {
                it
                    .addProperty("deleted", Boolean::class.java) { false }
                    .addProperty("create_time", Date::class.java) { Date() }
                    .addProperty("create_by", String::class.java) { getUser()?.username ?: SKIP }
            }
            .beforeUpdate {
                it
                    .overrideProperty("update_time") { Date() }
                    .overrideProperty("update_by") { getUser()?.username ?: SKIP }
            }
    }
}