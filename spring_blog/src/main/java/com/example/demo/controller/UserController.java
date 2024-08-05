package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*用户登录，并发放令牌给服务器
    * */
    @RequestMapping("/login")
    public Result login(String username,String password){

    }
}
