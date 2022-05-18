package cn.cloudself.start.util

import java.lang.ClassNotFoundException
import cn.cloudself.query.util.SpringUtils
import cn.cloudself.query.QueryProSql
import cn.cloudself.start.exception.IllegalCall
import cn.cloudself.start.exception.http.ServerException
import org.intellij.lang.annotations.Language
import org.slf4j.LoggerFactory

class ScriptUtilFunc {
    private val log = LoggerFactory.getLogger(ScriptUtilFunc::class.java)

    fun log(str: String?) {
        log.info(str)
    }

    //    public <T> T dubboReference(String interfaceName) {
    //        final ReferenceConfig<T> serviceRef = new ReferenceConfig<>();
    //        serviceRef.setInterface(interfaceName);
    //        return serviceRef.get();
    //    }

    fun springBean(interfaceName: String?): Any? {
        val clazz: Class<*> = try {
            Class.forName(interfaceName)
        } catch (e: ClassNotFoundException) {
            throw IllegalCall("找不到对应的class")
        }
        return SpringUtils.getBean(clazz)
    }

    fun throwResultException(errorMsg: String, vararg args: Any?) {
        throw ServerException(i18n(errorMsg, *args))
    }

    fun queryOne(@Language("SQL") sql: String): Any? {
        val row = queryOneAsMap(sql) ?: return null
        val iterator = row.values.iterator()
        return if (iterator.hasNext()) {
            iterator.next()
        } else null
    }

    fun queryOneAsMap(@Language("SQL") sql: String): Map<String, Any?>? {
        return QueryProSql.create(sql).queryOne()
    }

    fun queryAll(@Language("SQL") sql: String): List<Map<String, Any?>> {
        return QueryProSql.create(sql).query()
    }
}