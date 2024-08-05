package com.example.demo.controller;

import com.example.demo.model.BlogInfo;
import com.example.demo.model.Result;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /*实现博客列表,返回的是所有博客
    * */
    @RequestMapping("/getList")
    //返回的是列表，但会被统一数据返回结果，就会包装成result
    public List<BlogInfo> getList(){
        return blogService.getBlogList();
    }

    /*
    * 根据博客id动态获取博客页详情
    * */
    @RequestMapping("/getBlogDetails")
    public BlogInfo getBlogDetails(Integer blogId){
        return blogService.getBlogDetails(blogId);
    }
}
