package com.example.demo;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/request")
@RestController
public class RequestController {
    /*
    * 传递一个参数*/
    @RequestMapping("/r1")
    public String r1(String name){
        return "接收到的参数："+name;
    }
    /*
    传递多个参数，参数名称要匹配
    * */
    @RequestMapping("r2")
    public Object r2(String name, String password){
        return "name:"+name+"  password:"+password;
    }
    /*
    * 传递对象*/
    @RequestMapping("/r3")
    public Object r3(Person person){
        return person.toString();
    }

    /*
    后端参数映射
     */
    @RequestMapping("/r4")
    public Object r4(@RequestParam("time") String LLLtime){
        return "接收到的参数："+LLLtime;
    }

    /*
    * 传递数组*/
    @RequestMapping("/r5")
    public String r5(@RequestParam("array") String[] arrays)
    {
        return Arrays.toString(arrays);
    }
    /*
    * 传递集合,要用RequestParam 绑定参数关系*/
    @RequestMapping("/r6")
    public String r6(@RequestParam List<String> list){
        return "size:"+list.size()+",list:"+list;
    }
    /*
    * 上传文件*/
    @RequestMapping("/r7")
    public String getfile(@RequestPart("file")MultipartFile file) throws IOException {
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //文件上传到指定路径
        file.transferTo(new File(("D:/temp/"+file.getOriginalFilename())));
        return "接收到的文件名称为：" + fileName;
    }
    /*
    * 传统方式获取cookie,客户端保存信息的机制HttpServletRequest，HttpServletResponse是SpringMVC的内置对象*/
    @RequestMapping("/r8")
    public String r8(HttpServletRequest request, HttpServletResponse response){
        //获取所有cookie信息
        Cookie[] cookies = request.getCookies();
        //打印cookie信息
        StringBuilder builder = new StringBuilder();
        if(cookies != null){
            for(Cookie cookie : cookies){
                builder.append(cookie.getName()+":"+cookie.getValue());
            }
        }
        return "Cookie信息："+builder;
    }

    /*
    * 简洁方式获取cookie*/
    @RequestMapping("/r9")
    public String cookie(@CookieValue("bit") String bite){
        return bite;
    }
    /*
    * 获取session，由于是服务端机制，因此需要先存储在获取*/
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){
        //先获取session对象
        HttpSession session = request.getSession();
        if(session != null){
            session.setAttribute("username","C");
        }
        return "session 存储成功";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String username = null;
        if(session != null && session.getAttribute("username") != null){
            username =(String) session.getAttribute("username");

        }
        return "username : "+username;
    }
    /*
    简介获取1*/
    @RequestMapping("/getSession2")
    public String getSession2(@SessionAttribute(value = "username",required = false)String username){
        return "username : "+username;
    }

    /*
    * 简洁获取2*/
    @RequestMapping("/getSession3")
    public String getSession3(HttpSession session){
        String username = (String) session.getAttribute("username");
        return "username : "+username;
    }
    /*
    * 获取header*/
    //传统获取
    @RequestMapping("/r10")
    public String r10(HttpServletRequest request,HttpServletResponse response){
        String userAgent = request.getHeader("User-Agent");
        return "userAgent:"+userAgent;
    }
    /*
    * 简洁获取Header*/
    @RequestMapping("/r11")
    public String r11(@RequestHeader("User-Agent") String userAgent){
        return "userAgent:"+userAgent;
    }


}
