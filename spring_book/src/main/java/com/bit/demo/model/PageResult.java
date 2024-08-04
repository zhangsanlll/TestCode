package com.bit.demo.model;

import lombok.Data;

import java.util.List;

//翻页列表的结果类
@Data
public class PageResult<T> {
    private  PageRequest pageRequest;
    //所有记录数
    private int total;
    //当前页数据
    private List<T> records;



    //添加PageRequest属性
    public PageResult(Integer total,List<T> records,PageRequest pageRequest){
        this.total = total;
        this.records = records;
        this.pageRequest = pageRequest;
    }

}
