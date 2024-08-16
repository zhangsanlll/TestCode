package com.example.demo.model;

import lombok.Data;

import java.util.Date;

//定义表白墙的信息，即表白墙结构
@Data
public class MessageInfo {
    private String from;
    private String to;
    private String message;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
