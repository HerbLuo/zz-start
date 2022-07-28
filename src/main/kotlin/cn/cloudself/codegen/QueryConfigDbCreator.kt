package cn.cloudself.codegen

import cn.cloudself.codegen.antlr4.mysql.MySqlLexer
import cn.cloudself.codegen.antlr4.mysql.MySqlParser
import cn.cloudself.query.QueryProConfig
import cn.cloudself.query.QueryProTransaction
import cn.cloudself.start.components.logger
import cn.cloudself.start.dao.SysSelectElementQueryPro
import cn.cloudself.start.dao.SysSelectQueryPro
import cn.cloudself.start.entity.SysSelectElementEntity
import cn.cloudself.start.entity.SysSelectEntity
import cn.cloudself.start.util.JSON
import cn.cloudself.start.util.StringTemplate
import cn.cloudself.start.util.StringUtil.split
import cn.cloudself.start.util.StringUtil.unwrapEscapedChar
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.intellij.lang.annotations.Language
import org.slf4j.LoggerFactory
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.io.InputStream
import javax.sql.DataSource

@Language("json")
val kvAbbrJson = """{
    "string": {
        "type": "string",
        "limit_conditions": {"等于": "=", "不等于": "<>", "包含": {"value": "inc", "default": true}, "不包含": "!inc"}
    },
    "number": {
        "type": "number",
        "limit_conditions": {"等于": "=", "不等于": "<>", "大于":">", "大于等于":">=", "小于":"<", "小于等于":"<=", "范围":"~"}
    },
    "datetime": {
        "type": "datetime",
        "limit_conditions": {"等于": "=", "不等于": "<>", "大于":">", "大于等于":">=", "小于":"<", "小于等于":"<=", "范围":"~"}
    },
    "date": {
        "type": "date",
        "limit_conditions": {"等于": "=", "不等于": "<>", "大于":">", "大于等于":">=", "小于":"<", "小于等于":"<=", "范围":"~"}
    },
    "month": {
        "type": "month",
        "limit_search_conditions": {"等于": "=", "不等于": "<>", "大于":">", "大于等于":">=", "小于":"<", "小于等于":"<=", "范围":"~"}
    },
    "year": {
        "type": "year",
        "limit_search_conditions": {"等于": "=", "不等于": "<>", "大于":">", "大于等于":">=", "小于":"<", "小于等于":"<=", "范围":"~"}
    },
    "values": {
        "type": "select",
        "limit_type": "values",
        "limit_search_conditions": {"等于": "=", "不等于": "<>", "包含": "inc", "不包含": "!inc"}
    },
    "dict": {
        "type": "select",
        "limit_type": "dictionary",
        "limit_search_conditions": {"等于": "=", "不等于": "<>", "包含": "inc", "不包含": "!inc"}
    },
    "options": {
        "type": "select",
        "limit_type": "select_option",
        "limit_search_conditions": {"等于": "=", "不等于": "<>", "包含": "inc", "不包含": "!inc"}
    },
    "options-url": {
        "type": "select",
        "limit_type": "url",
        "limit_search_conditions": {"等于": "=", "不等于": "<>", "包含": "inc", "不包含": "!inc"}
    }
}"""

@Language("JSON")
val keyAbbrJson = """{
    "values": "limit_values"
}"""

@Language("JSON")
val valueAbbrJson = """{
    "是否": {"否": 0, "是": 1}
}"""

val kvAbbr = JSON.parse(kvAbbrJson, object : TypeReference<LinkedHashMap<String, MutableMap<String, Any>>>(){})
    .also {
        for (map in it.values) {
            map.replaceAll { _, v -> if (v !is String) JSON.stringify(v) else v }
        }
    }

val keyAbbr = JSON.parse(keyAbbrJson, object : TypeReference<LinkedHashMap<String, Any>>(){})

val valueAbbr = JSON.parse(valueAbbrJson, object : TypeReference<LinkedHashMap<String, Any>>(){})
    .also {
        it.replaceAll { _, v -> if (v !is String) JSON.stringify(v) else v }
    }

class CodeGenError(message: String, vararg args: Any?) : RuntimeException(StringTemplate.of(message, *args))

class QueryConfigDbCreator {
    companion object {
        private val log = LoggerFactory.getLogger(QueryConfigDbCreator::class.java)

        @JvmStatic
        fun dataSource(dataSource: DataSource): QueryConfigDbCreator {
            QueryProConfig.global.setDataSource(dataSource)
            return QueryConfigDbCreator()
        }
    }

    fun ofResources() {
        val cl = QueryConfigDbCreator::class.java.classLoader
        val resolver = PathMatchingResourcePatternResolver(cl)
        val resources = resolver.getResources("search_configs/*.sql")
        for (resource in resources) {
            val filename = resource.filename
            val sqlIs = resource.inputStream
            ofSql(filename?.substring(0, filename.length - 4), sqlIs)
        }
    }

    private fun ofSql(filename: String?, sqlIs: InputStream, force: Boolean = false) { QueryProTransaction.use {
        val sql = sqlIs.reader().readText()
        val charStream = CharStreams.fromString(sql)
        val lexer = MySqlLexer(charStream)
        val tokenStream = CommonTokenStream(lexer)
        val parser = MySqlParser(tokenStream)
        val selectStatement = parser.querySpecification()
        val selectElements = selectStatement.selectElements()
        if (selectElements.star != null) { throw CodeGenError("不支SELECT * 语句") }
        val selectElementList = selectElements.selectElement()

        val tag = toPinyin(filename ?: "_")

        log.info("{} 解析中", tag)

        val sysSelect = SysSelectEntity()
        sysSelect.tagCn = filename
        sysSelect.tag = tag
        sysSelect.sqlColumn = sql.trim()

        // 生成或获取表头ID
        val queryIdNullable = SysSelectQueryPro.selectBy().tag.equalsTo(tag).columnLimiter().id().firstOrNull()
        val queryId = if (queryIdNullable == null) {
            SysSelectQueryPro.insert(sysSelect) ?: throw CodeGenError("insert方法没有返回ID")
        } else {
            SysSelectQueryPro.updateSet(sysSelect).where.id.equalsTo(queryIdNullable).run()
            queryIdNullable
        }

        // 创建或修改了新的select elements后, 旧的会删除
        val currentElementIds = mutableListOf<Long>()

        for ((i, selectElementContext) in selectElementList.withIndex()) {
            val comma = selectElements.COMMA(i)
            val tokenIndex = comma?.symbol?.tokenIndex ?: selectElementContext.getStop().tokenIndex
            val hiddenTokens = tokenStream.getHiddenTokensToRight(tokenIndex)
            val comment = hiddenTokens?.find { MySqlLexer.LINE_COMMENT == it.type || MySqlLexer.COMMENT == it.type }?.text

            if (selectElementContext is MySqlParser.SelectStarElementContext) {
                logger.warn("不支持解析table.* 这种写法， 跳过该字段")
                continue
            }

            val (alias, selectElementSql) = getColumnNameAndSql(selectElementContext)
            log.info("当前解析的字段(别名)是 {}", alias)
            val columnInfo = parseComment(comment)
            columnInfo.putIfAbsent("sort", (i + 1) * 10000)
            val aliasCn = columnInfo["alias_cn"]
            log.info("当前解析的字段名是 {}", aliasCn)

            val columnEntity = SysSelectElementEntity()
            columnEntity.sysSelectId = queryId
            columnEntity.tagCn = filename
            columnEntity.alias = alias
            columnEntity.sqlColumn = selectElementSql
            val columnEntityMap = ObjectMapper().convertValue(columnEntity, object : TypeReference<Map<String, Any?>>() {})

            for ((key, value) in columnEntityMap) {
                if (value != null) {
                    columnInfo[key] = value
                }
            }

            val elementId = SysSelectElementQueryPro
                .selectBy().sysSelectId.equalsTo(queryId)
                .and().alias.equalsTo(alias).columnLimiter().id()
                .let {
                    if (it.isEmpty() && aliasCn != null) {
                        SysSelectElementQueryPro
                            .selectBy().sysSelectId.equalsTo(queryId)
                            .and().aliasCn.equalsTo(aliasCn).columnLimiter().id()
                    } else {
                        it
                    }
                }
                .let {
                    if (it.size == 1) it[0] else null
                }

            if (elementId == null) {
                val id = SysSelectElementQueryPro.insert(columnInfo).firstOrNull()
                    ?: throw CodeGenError("insert返回了null")
                currentElementIds.add(id)
            } else {
                SysSelectElementQueryPro.updateSet(columnInfo).where.id.equalsTo(elementId).run()
                currentElementIds.add(elementId)
            }
        }

        SysSelectElementQueryPro
            .deleteBy().sysSelectId.equalsTo(queryId)
            .and().id.not.`in`(*currentElementIds.toTypedArray())
            .run()
    } }

    private fun parseComment(comment: String?): MutableMap<String, Any?> {
        val result = mutableMapOf<String, Any?>()
        val infos = comment?.substring(1)?.split(' ')?.map { it.trim() }?.filter { it.isNotEmpty() }
            ?: return mutableMapOf()

        val aliasCn = infos.first().unwrapEscapedChar()
        result["alias_cn"] = aliasCn
        for (info in infos.subList(1, infos.size)) {
            val cfg = kvAbbr[info]
            if (cfg != null) {
                result.putAll(cfg)
                continue
            }
            val kv = info.split('=').map { it.unwrapEscapedChar() }
            if (kv.size != 2) {
                throw CodeGenError("无法解析的备注: {}, 格式key=value", info)
            }
            val (k, v) = kv
            val key = keyAbbr[k]?.toString() ?: k
            val value = valueAbbr[v]?.toString() ?: v
            result[key] = value
        }

        // 需要提前处理
        if (result["type"] == null) {
            val cfg = kvAbbr["string"]
            if (cfg != null) {
                for ((k, v) in cfg) {
                    if (result[k] == null) {
                        result[k] = v
                    }
                }
            }
        }
        return result
    }

    private fun getColumnNameAndSql(selectElementContext: MySqlParser.SelectElementContext): Pair<String, String> {
        val sql: String
        val columnNameWithReverseQuote = when (selectElementContext) {
            is MySqlParser.SelectColumnElementContext -> {
                sql = selectElementContext.fullColumnName().text
                selectElementContext.uid()?.text /* col as uid */
                    ?: selectElementContext.fullColumnName().text.split('.').last()
            }
            is MySqlParser.SelectFunctionElementContext -> {
                sql = selectElementContext.functionCall().text
                selectElementContext.uid()?.text
                    ?: throw CodeGenError("{} FunctionCall必须添加别名，例子 ifnull(col, 0) as col", selectElementContext)
            }
            is MySqlParser.SelectExpressionElementContext -> {
                sql = selectElementContext.expression().text
                selectElementContext.uid()?.text
                    ?: throw CodeGenError("{} Expression必须添加别名，例子 ifnull(col, 0) as col", selectElementContext)
            }
            else -> {
                throw CodeGenError("未知的select表达式类型: {}", selectElementContext.javaClass)
            }
        }

        val startIndex = if (columnNameWithReverseQuote.startsWith('`')) 1 else 0
        val endIndex = if (columnNameWithReverseQuote.endsWith('`')) -1 else 0

        val columnName = if (startIndex != 0 || endIndex != 0) {
            columnNameWithReverseQuote.substring(startIndex, columnNameWithReverseQuote.length + endIndex)
        } else columnNameWithReverseQuote

        return columnName to sql
    }

    private fun toPinyin(chinese: String) =
        PinyinHelper.toHanYuPinyinString(chinese + "_", pinyinFormat, "_", true).dropLast(1)

    private val pinyinFormat = HanyuPinyinOutputFormat().also {
        it.toneType = HanyuPinyinToneType.WITHOUT_TONE
        it.vCharType = HanyuPinyinVCharType.WITH_V
    }
}
