package cn.cloudself.start.service

import cn.cloudself.start.pojo.Login

interface IUserService {
    fun loginByUsernameAndPassword(): Login
}
