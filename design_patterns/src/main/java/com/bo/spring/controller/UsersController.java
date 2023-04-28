package com.bo.spring.controller;

import com.bo.spring.service.DdService;
import com.bo.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private DdService ddService;

    @GetMapping("/test")
    public void test(){
        try{
            usersService.add();
           // ddService.add();
        }catch (Throwable throwable){
            System.out.println(throwable.getMessage());
            System.out.println("数据一经回滚g");
        }
    }

}
