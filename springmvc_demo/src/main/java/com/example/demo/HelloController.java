package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

/*
* 注册接口路由映射，url的路径是类路径+方法路径
* */
@RequestMapping("/user")//修饰类
public class HelloController {
    @RequestMapping("/hello")//修饰方法
    public String hello(){
        return "123";
    }
}
