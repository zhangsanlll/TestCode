package com.bit.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* 测试代码：统一数据返回中String类型会发生错误，测试
* */
@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping("/t1")
    public String t1(){
        return "t1";
    }

    @RequestMapping("/t2")
    public Integer t2(){
        int a = 10/0;//抛出ArithmeticException异常
        return 0;
    }
    @RequestMapping("/t3")
    public boolean t3(){
        String a = null;
        System.out.println(a.length());//抛出NullPointException异常
        return true;
    }
}
