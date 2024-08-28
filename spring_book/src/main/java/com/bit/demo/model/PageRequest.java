package com.bit.demo.model;

import lombok.Data;

//翻页请求对象
@Data
public class PageRequest {
    //当前页的第一个数
    private int currentPage = 1;
    //每页显示的条数
    private int pageSize = 10;
    private int offset;


    public int getOffset() {
        return (currentPage - 1)* pageSize;
    }
}
