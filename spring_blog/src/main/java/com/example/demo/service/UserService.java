package com.example.demo.service;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    //通过username获取改用户的所有信息
    public UserInfo getUserInfo(String username) {
        return userInfoMapper.selectByName(username);
    }
}
