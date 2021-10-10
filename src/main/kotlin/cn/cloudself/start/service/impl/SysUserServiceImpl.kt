package cn.cloudself.start.service.impl

import cn.cloudself.start.pojo.Login
import cn.cloudself.start.service.IUserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SysUserServiceImpl : IUserService {
    private val logger = LoggerFactory.getLogger(SysUserServiceImpl::class.java)

    override fun loginByUsernameAndPassword(): Login {
        logger.warn("尚未实现")
        return Login(1, "", "")
    }
}