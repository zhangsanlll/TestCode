package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
//后端代码
//校验接口，校验用户名密码和账号是否正确
public class LoginController {
    /*校验用户名密码和账号是否正确,返回true或false
    * */
    @RequestMapping("/login")
    public Boolean login(String userName, String passWord, HttpSession session){
    //参数校验，用 Spring MVC自带的方法
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(passWord)){
            return false;//如果两个参数为空返回false
        }
        //理论上应从数据库中获取账号和密码，此时还没有学，就自定义,常量在前面防止null，双重保险
        if("zhangsan".equals(userName) && "123456".equals(passWord)){
            //账号密码正确应存储在session中以便后续获取账号
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
    /*
    查询当前用户的账号
    */

    @RequestMapping("/index")
    public String getIndex(HttpSession session){
        String name = (String) session.getAttribute("userName");
        return name;
    }

}
