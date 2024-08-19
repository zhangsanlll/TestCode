package com.example.demo.controller;

import com.example.demo.model.ListConfig;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ReadYml {
    @Value("${string.str1}")
    private String str1;
    @Value("${string.str2}")
    private String str2;
    @Value("${string.str3}")
    private String str3;

    @RequestMapping("/yml1")
    public String yml1(){
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        return "yml";
    }

    //配置对象
    @Autowired
    private Student student;

    @RequestMapping("/yml2")
    public String yml2(){
        return student.toString();
    }

    //配置集合
    @Autowired
    private ListConfig listConfig;

    @RequestMapping("/yml3")
    public String yml3(){
        return listConfig.toString();
    }
}
