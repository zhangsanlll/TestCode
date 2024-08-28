package com.bit.demo.advice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bit.demo.model.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice//控制通知类，统一数据返回格式
public class ResponseAdvice implements ResponseBodyAdvice {
    private static ObjectMapper mapper = new ObjectMapper();

    /*
    判断是否执行beforeBodyWrite方法，true为执行
    * */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(body instanceof Result){
            return body;
        }
        //如果返回结果为String类型，使用SpringBoot内置的Jackson来实现信息的序列化
        if(body instanceof String){
            return mapper.writeValueAsString(Result.success(body));
        }
        return Result.success(body);
    }
}
