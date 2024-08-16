package com.example.demo.service;

import com.example.demo.mapper.MessageInfoMapper;
import com.example.demo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    //讲mapper中的方法注入到业务逻辑层，在这里实现

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    public  List<MessageInfo> selectAll(){
          return messageInfoMapper.selectAll();
    }

    public Integer addMessage(MessageInfo messageInfo){
          return messageInfoMapper.addMessage(messageInfo);
    }


}
