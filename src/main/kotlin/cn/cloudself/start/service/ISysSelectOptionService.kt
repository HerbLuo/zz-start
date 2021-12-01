package cn.cloudself.start.service

import cn.cloudself.start.pojo.SysSelectOptionRes

interface ISysSelectOptionService {
    fun getSelectOptions(key: String): List<SysSelectOptionRes>

    fun getSelectOptions(table: String, label: String, value: String): List<SysSelectOptionRes>
}