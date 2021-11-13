package cn.cloudself.start.service.impl

import cn.cloudself.start.interactive.res.Confirm
import cn.cloudself.start.service.IConfirmTestService
import org.springframework.stereotype.Service

@Service
class ConfirmTestServiceImpl: IConfirmTestService {
    override fun testConfirm(): Confirm {
        return Confirm(
            "确认删除？",
            onOk = ConfirmTestServiceImpl::deleteById,
            onNo = null
        )
    }

    fun deleteById(id: Long) {
        println("deleting")
    }
}