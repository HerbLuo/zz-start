package cn.cloudself.start.service

import cn.cloudself.start.pojo.SelectOptionRes

interface ISelectOptionService {
    fun getSelectOptions(key: String): List<SelectOptionRes>

    fun getSelectOptions(table: String, label: String, value: String): List<SelectOptionRes>
}