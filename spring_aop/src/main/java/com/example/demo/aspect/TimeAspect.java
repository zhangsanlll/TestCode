package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j//打印日志注解
@Component//五大组件
@Aspect//切面
public class TimeAspect {
    //记录方法耗时
//    @Around("execution(* com.example.demo.controller.*.*(..))")
    @Around("com.example.demo.aspect.pt()                                                              ")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        //记录方法执行开始时间
        long begin = System.currentTimeMillis();
        //执行原始方法,peoceed()会报错，直接抛出异常
        Object result = pjp.proceed();
        //记录方法执行结束时间
        long end = System.currentTimeMillis();
        //记录方法执行耗时
        log.info(pjp.getSignature()+"执行耗时：{}ms",end - begin);
        return result;
    }

}
