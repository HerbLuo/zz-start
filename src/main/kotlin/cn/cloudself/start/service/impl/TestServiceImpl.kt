package cn.cloudself.start.service.impl

import cn.cloudself.start.dao.SysUserQueryPro
import cn.cloudself.start.service.ITestService
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class TestServiceImpl: ITestService {

    @Transactional
    override fun test() {
        SysUserQueryPro.updateSet().userName("new name").where.id.equalsTo(1).run()
        if (1 == 1) {
            throw RuntimeException("ceshi")
        }
        SysUserQueryPro.updateSet().userName("loo2").password("1234567").where.id.equalsTo(1).run()
    }


}