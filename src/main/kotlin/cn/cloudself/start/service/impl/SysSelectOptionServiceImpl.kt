package cn.cloudself.start.service.impl

import cn.cloudself.query.QueryProSql
import cn.cloudself.start.annotation.AutoLog
import cn.cloudself.start.dao.SysSelectOptionQueryPro
import cn.cloudself.start.entity.SysSelectOptionEntity
import cn.cloudself.start.exception.http.RequestNotFindException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.pojo.SysSelectOptionRes
import cn.cloudself.start.service.ISysSelectOptionService
import org.springframework.stereotype.Service

@AutoLog
@Service
class SysSelectOptionServiceImpl : ISysSelectOptionService {
    override fun getSelectOptions(key: String): List<SysSelectOptionRes> {
        val selectOptionConfig = SysSelectOptionQueryPro.selectBy().key.equalsTo(key).runLimit1()
            ?: throw RequestNotFindException()
        return getSelectOptions(selectOptionConfig)
    }

    override fun getSelectOptions(table: String, label: String, value: String): List<SysSelectOptionRes> {
        val selectOptionConfigList = SysSelectOptionQueryPro
            .selectBy().table.equalsTo(table)
            .and().label.equalsTo(label)
            .and().value.equalsTo(value)
            .runAsList()
        if (selectOptionConfigList.isEmpty()) {
            throw RequestNotFindException()
        }
        if (selectOptionConfigList.size > 1) {
            throw ServerException("SysSelectOption数据库配置错误")
        }
        return getSelectOptions(selectOptionConfigList[1])
    }

    private fun getSelectOptions(selectOptionConfig: SysSelectOptionEntity): List<SysSelectOptionRes> {
        val sqlBuilder = StringBuilder("SELECT ")
        sqlBuilder.append(selectOptionConfig.label, " AS `label`,")
        sqlBuilder.append(selectOptionConfig.value, " AS `value`")

        val defaultClause = selectOptionConfig.defaultClause
        if (!defaultClause.isNullOrBlank()) {
            sqlBuilder.append(", ", defaultClause, " AS `default`")
        }
        val payload = selectOptionConfig.payload
        if (!payload.isNullOrBlank()) {
            sqlBuilder.append(", ", payload)
        }
        // 不要在where后添加 'deleted = false',  因为有时候我们需要搜索历史数据
        sqlBuilder.append(" FROM", selectOptionConfig.table)
        sqlBuilder.append(" WHERE true")

        val whereClause = selectOptionConfig.whereClause
        if (!whereClause.isNullOrBlank()) {
            sqlBuilder.append(" AND ", whereClause)
        }
        val orderByClause = selectOptionConfig.orderByClause
        if (!orderByClause.isNullOrBlank()) {
            sqlBuilder.append(" ORDER BY ", orderByClause)
        }

        return if (payload?.isNotBlank() == true) {
            val payloadList = QueryProSql.create(sqlBuilder.toString()).query(mutableMapOf<String, Any?>().javaClass)
            payloadList.map {
                SysSelectOptionRes(
                    label = it.remove("label") as String?,
                    value = it.remove("value") as String?,
                    default = it.remove("default") as Boolean? ?: false,
                    payload = it
                )
            }
        } else {
            QueryProSql.create(sqlBuilder.toString()).query(SysSelectOptionRes::class.java)
        }
    }
}