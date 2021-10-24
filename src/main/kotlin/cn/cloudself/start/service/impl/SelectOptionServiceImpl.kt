package cn.cloudself.start.service.impl

import cn.cloudself.query.QueryProSql
import cn.cloudself.start.annotation.AutoLog
import cn.cloudself.start.dao.SysSelectOptionQueryPro
import cn.cloudself.start.entity.SysSelectOptionEntity
import cn.cloudself.start.exception.http.RequestNotFindException
import cn.cloudself.start.exception.http.ServerException
import cn.cloudself.start.pojo.SelectOptionRes
import cn.cloudself.start.service.ISelectOptionService
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils

@AutoLog
@Service
class SelectOptionServiceImpl : ISelectOptionService {
    override fun getSelectOptions(key: String): List<SelectOptionRes> {
        val selectOptionConfig = SysSelectOptionQueryPro.selectBy().key.equalsTo(key).runLimit1()
            ?: throw RequestNotFindException()
        return getSelectOptions(selectOptionConfig)
    }

    override fun getSelectOptions(table: String, label: String, value: String): List<SelectOptionRes> {
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

    private fun getSelectOptions(selectOptionConfig: SysSelectOptionEntity): List<SelectOptionRes> {
        val sqlBuilder = StringBuilder("SELECT ")
        sqlBuilder.append(selectOptionConfig.label, " AS `label`,")
        sqlBuilder.append(selectOptionConfig.value, " AS `value`")

        val defaultClause = selectOptionConfig.defaultClause
        if (defaultClause?.isNotBlank() == true) {
            sqlBuilder.append(", ", defaultClause, " AS `default`")
        }
        val payload = selectOptionConfig.payload
        if (payload?.isNotBlank() == true) {
            sqlBuilder.append(", ", payload, " AS `payload`")
        }
        sqlBuilder.append(" FROM ", selectOptionConfig.table, " WHERE deleted = false AND status = 'success'")
        val whereClause = selectOptionConfig.whereClause
        if (!ObjectUtils.isEmpty(whereClause)) {
            sqlBuilder.append(" AND ", whereClause)
        }
        val orderByClause = selectOptionConfig.orderByClause
        if (orderByClause != null) {
            sqlBuilder.append(" ORDER BY ", orderByClause)
        }

        return QueryProSql.create(sqlBuilder.toString()).query(SelectOptionRes::class.java)
    }
}