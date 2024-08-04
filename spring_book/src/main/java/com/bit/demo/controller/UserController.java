package com.bit.demo.controller;

import com.bit.demo.model.Constants;
import com.bit.demo.model.UserInfo;
import com.bit.demo.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//实现登录验证接口
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public boolean login(String username,String password , HttpSession session){

        //1、校验账号和密码是否为空
        if(!StringUtils.hasLength(username)||!StringUtils.hasLength(password)){
            return false;
        }
        //将对应账号的信息存入userinfo中，进行后续的校验密码
        UserInfo userInfo = userInfoService.selectUserByName(username);
        if(userInfo == null){
            return false;
        }

        //2、验证该用户的密码是否正确
        if(userInfo != null && password.equals(userInfo.getPassWord())){
            //3、将用户信息保存在session中
            userInfo.setPassWord("");
            session.setAttribute(Constants.SESSION_USER_KEY,userInfo);
            return true;
        }

        return false;
    }

}
