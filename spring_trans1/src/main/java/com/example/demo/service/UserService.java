package com.example.demo.service;

import com.example.demo.mapper.UserInfoMapper;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j

public class UserService {
    @Autowired
    //注入mapper
    private UserInfoMapper userInfoMapper;

    @Transactional(propagation = Propagation.NESTED)

    public void registryUser(String userName,String password){
        //插入用户信息
        userInfoMapper.insert(userName,password);
    }

}
