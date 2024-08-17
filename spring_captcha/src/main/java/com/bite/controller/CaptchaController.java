package com.bite.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.bite.properties.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Date;


//生成校验码
@RequestMapping("/captcha")
@RestController
public class CaptchaController {
    private final static long VALID_MILLIS_TIME = 60*1000;
    @Autowired
    private CaptchaProperties captchaProperties;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session){
        //定义扭曲干扰图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight(),
                captchaProperties.getCodeCount(), captchaProperties.getThickness());
        /*//定义线条干扰图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());*/
        //设置内容类型
        response.setContentType("/image/jpeg");
        //禁止使用缓存
        response.setHeader("Progma","No-cache");
        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            //输出到页面
            captcha.write(response.getOutputStream());
            session.setAttribute(captchaProperties.getSession().getKey(),captcha.getCode());
            session.setAttribute(captchaProperties.getSession().getDate(),new Date());
            //打印日志
            System.out.println("生成的验证码："+captcha.getCode());
            //关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @RequestMapping("/check")
    public boolean check(String captcha, HttpSession session){
        //校验参数
        if(!StringUtils.hasLength(captcha)){
            return false;
        }
        //从session中拿到key和date
        String savedCaptcha = (String)session.getAttribute(captchaProperties.getSession().getKey());
        Date sessionDate = (Date) session.getAttribute(captchaProperties.getSession().getDate());
        //判断验证码和拿到的验证码是否相同，忽略大小写
        if(captcha.equalsIgnoreCase(savedCaptcha)){
            if(sessionDate != null && System.currentTimeMillis()-sessionDate.getTime() < VALID_MILLIS_TIME){
                return true;
            }
        }
        return false;
    }
}
