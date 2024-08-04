package com.example.demo.controller;

import com.example.demo.service.LogService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/propagation")
public class PropagationController {
    //调用两个，三个事务
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

//    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("/p1")
    public String p1(String name,String password){
        //用户注册
        userService.registryUser(name,password);
        //记录操作日志
        logService.insertLog(name,"用户注册");
        return "p1";
    }
}
