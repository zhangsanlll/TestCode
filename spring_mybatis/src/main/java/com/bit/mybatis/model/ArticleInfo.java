package com.bit.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    //用户的相关信息，用于多表查询
    private String username;
    private Integer age;
    private Integer gender;

}
