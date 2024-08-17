package com.bite.properties;


//此类是验证码配置项对应的Java对象

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("captcha")
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Integer codeCount;
    private Integer thickness;
    private Session session;

    //内部类
    @Data
    public static class Session{
        private String key;
        private String date;
    }
}
