package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AspectDemo {
    //定义公共切点
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    //如果用public修饰，就可以在其他类中调用改公共切点，引用方式为：全限定类名.方法名（）
    private void pt(){}

    //环绕通知
    @Around("pt()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        //记录方法执行开始时间
        log.info("Around方法开始执行");
        Object result = pjp.proceed();
        log.info("Around方法结束执行");
        return result;
    }
    //前置通知
    @Before("pt()")
    public void doBefore()  {
        log.info("执行Before方法");
    }

    //后置通知
    @After("pt()")
    public void doAfter()  {
        log.info("执行After方法");
    }

    //返回后通知
    @AfterReturning("pt()")
    public void doAfterReturning()  {
        log.info("执行AfterReturning方法");
    }

    //抛出异常后通知
    @AfterThrowing("pt()")
    public void doAfterThrowing() {
        log.info("执行AfterThrowing方法");
    }


}
