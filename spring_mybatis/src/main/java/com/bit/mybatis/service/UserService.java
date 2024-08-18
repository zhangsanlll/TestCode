package com.bit.mybatis.service;

import com.bit.mybatis.mapper.UserInfoMapper;
import com.bit.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo selectTest(String username,String password){
        List<UserInfo> userInfos =  userInfoMapper.selectTest(username,password);
        if(userInfos != null && userInfos.size() >0){
            return userInfos.get(0);
        }
        return null;
    }

}
