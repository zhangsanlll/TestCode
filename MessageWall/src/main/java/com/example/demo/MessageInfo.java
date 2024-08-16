package com.example.demo;

import lombok.Data;

//定义表白墙的信息，即表白墙结构
@Data
public class MessageInfo {
    private String from;
    private String to;
    private String say;

}
