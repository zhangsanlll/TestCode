package com.bit.ioc.controller;

//使用Controller注解存储bean

import com.bit.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//将对象存储到Spring对象中
@Controller
public class UserController {

    //1、属性注入
/*    @Autowired
    private UserService userService;
    public void sayHi(){
        System.out.println("hi,Controller");
        userService.sayHi();
    }*/

    //2、构造方法注入

 /*   private UserService userService;
    public UserController(){

    }
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public void sayHi(){
        System.out.println("hi,Controller");
        userService.sayHi();
    }*/

    //3、Setter注入

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    public void sayHi(){
        System.out.println("hi,Controller");
        userService.sayHi();
    }
}
