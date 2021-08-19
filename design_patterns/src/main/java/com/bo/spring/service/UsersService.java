package com.bo.spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.spring.pojo.Users;

public interface UsersService extends IService<Users> {

    void add() throws Exception;
}