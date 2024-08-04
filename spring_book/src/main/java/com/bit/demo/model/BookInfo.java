package com.bit.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;//图书订阅状态
    private String statusCN;//图书订阅状态的含义
    private Date createTime;
    private Date updateTime;
}
