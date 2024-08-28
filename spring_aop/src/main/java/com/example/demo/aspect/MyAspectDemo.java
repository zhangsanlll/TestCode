package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspectDemo {
    //前置通知
    @Before("annotation(com.example.demo.aspect.MyAspect)")
    public void doBefore()  {
        log.info("MyAspect->Before...");
    }

    //后置通知
    @After("annotation(com.example.demo.aspect.MyAspect)")
    public void doAfter()  {
        log.info("MyAspect->After...");
    }
}
