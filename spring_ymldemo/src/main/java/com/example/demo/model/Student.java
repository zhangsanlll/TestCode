package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//交给spring管理
@Component
//读取配置对象
@ConfigurationProperties(prefix = "student")
public class Student {
    private int id;
    private String name;
    private int age;
}
