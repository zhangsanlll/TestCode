package com.example.demo.controller;


import com.example.demo.aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    public Integer t1(){
        int a = 10;
        int b = 15;
        return a * b;
    }

    @RequestMapping("/t2")
    public Long t2(){
        long ret = 1;
        for(long i = 1;i < 1000;i++){
            ret *= i;
        }
        return ret;
    }

    @RequestMapping("/t3")
    public boolean t3(){
        int a = 10;
        int b = 15;
        return a > b;
    }

    @RequestMapping("/t4")
    public boolean t4(){
        int a = 10 / 0;
        return true;
    }

    @MyAspect
    @RequestMapping("/t5")
    public String  t5(){
        return "true";
    }
}
