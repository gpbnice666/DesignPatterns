package com.bo.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bo.spring.mapper.UsersMapper;
import com.bo.spring.pojo.Users;
import com.bo.spring.service.DdService;
import com.bo.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {


    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private DdService ddService;

    private  ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add () throws Exception {

        Users users = new Users();
        users.setAge(100);
        users.setName("123");
        usersMapper.insert(users);
        poolExecutor.execute(()->{
            ddService.add();
        });
    }
}