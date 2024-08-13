package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1,Integer num2){
        Integer sum = num1 + num2;
        return "<h1>计算机计算结果："+sum+"</h1>";
    }

}
