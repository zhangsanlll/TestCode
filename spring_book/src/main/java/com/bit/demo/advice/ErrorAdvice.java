package com.bit.demo.advice;

import com.bit.demo.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//如果代码出现Exception异常，就会返回一个Result对象
@ControllerAdvice//控制器通知类
@ResponseBody//异常处理类
public class ErrorAdvice {
    @ExceptionHandler
    public Object handler(Exception e){
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Object handler(NullPointerException e){
        return Result.fail("发生NullPointerException："+e.getMessage());
    }

    @ExceptionHandler
    public Object handler(ArithmeticException e){
        return Result.fail("发生ArithmeticException："+e.getMessage());
    }
}
