package com.example.demo.controller;

import com.example.demo.model.MessageInfo;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
后端提供的服务：提交留言，用户输入用户留言后，后端需要把留言信息保存起来
             展示留言，页面展示时，需要从后端获取所有的留言信息
* */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    //

    @RequestMapping("/getList")
    public List<MessageInfo> getList(){

        return messageService.selectAll();
    }


    @RequestMapping("/publish")
    public boolean publish(MessageInfo messageInfo){
        System.out.println(messageInfo);
        //校验数据
        if(StringUtils.hasLength(messageInfo.getFrom()) ||
        StringUtils.hasLength(messageInfo.getTo()) ||
        StringUtils.hasLength(messageInfo.getMessage())){
            //添加数据到后端存储
            messageService.addMessage(messageInfo);
            return true;
        }
        return false;
    }

}
