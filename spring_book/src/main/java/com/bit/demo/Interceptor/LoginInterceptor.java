package com.bit.demo.Interceptor;

import com.bit.demo.model.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //从session中获取用户信息，如果用户信息不存在，返回false，并设置http状态401，否则返回true
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器拦截LoginInterceptor....");
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute(Constants.SESSION_USER_KEY) != null){
            return true;
        }
        response.setStatus(401);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LoginInterceptor 目标方法执行后执行...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LoginInterceptor 视图渲染完毕后执行，最后执行...");
    }
}
