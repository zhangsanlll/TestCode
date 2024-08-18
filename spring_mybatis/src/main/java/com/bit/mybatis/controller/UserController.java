package com.bit.mybatis.controller;

import com.bit.mybatis.model.UserInfo;
import com.bit.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    //注入service业务层
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public boolean login(String name,String password){

        UserInfo userInfo = userService.selectTest(name,password);
        if(userInfo != null){
            return true;
        }
        return false;
    }
}
