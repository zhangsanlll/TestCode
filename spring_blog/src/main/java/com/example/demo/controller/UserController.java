package com.example.demo.controller;

import com.example.demo.jwt.JWTUtils;
import com.example.demo.model.Result;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*用户登录，并发放令牌给服务器
    * */
    @RequestMapping("/login")
    //令牌需要由客户端自己存储
    public Result login(HttpServletRequest request, HttpServletResponse response,
                        String username, String password){
        //判断参数的合法性
        if(!StringUtils.hasLength(username)||!StringUtils.hasLength(password)){
            log.error("username:{}",username,"password:{}",password);
            return Result.fail(-1,"用户或密码为空");
        }
        //判断密码是否正确
        UserInfo userInfo = userService.getUserInfo(username);
        if(userInfo == null || ! password.equals(userInfo.getPassword())){
            return Result.fail(-1,"用户或密码错误");
        }
        //登录成功，返回token给客户端
        Map<String,Object> claims = new HashMap<>();
        //此处不可将用户的敏感信息传给客户端
        claims.put("id",userInfo.getId());
        claims.put("username",userInfo.getUserName());
        String token = JWTUtils.genJwt(claims);
        System.out.println("生成token"+token);
        return Result.success(token);


    }
}
