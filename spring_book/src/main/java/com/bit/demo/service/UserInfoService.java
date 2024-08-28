package com.bit.demo.service;

import com.bit.demo.mapper.UserInfoMapper;
import com.bit.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo selectUserByName(String username){
        return userInfoMapper.selectUserByName(username);
    }
}
