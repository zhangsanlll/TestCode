package com.bit.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
//和数据库对应的字段，字段名最好相同（不同的话可以用自动驼峰方式解决），搞清前后端交互
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
