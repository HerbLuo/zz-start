package cn.cloudself.start.service.impl

import cn.cloudself.start.react.res.Confirm
import cn.cloudself.start.service.IConfirmTestService
import org.springframework.stereotype.Service

@Service
class ConfirmTestServiceImpl: IConfirmTestService {
    override fun testConfirm(): Confirm {
        return Confirm(
            "确认删除？",
            this::deleteAll,
            null
        )
    }

    fun deleteAll() {
        println("deleting")
    }
}