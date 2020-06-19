package com.nari.dhsm.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yinyx
 * @version 1.0 2020/6/15
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        this.log.info("[****LoginInterceptor.preHandle****" );
       return true;

    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        this.log.info("[****LoginInterceptor.postHandle****");
        this.log.info("[****LoginInterceptor.postHandle****" + modelAndView);

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        this.log.info("[****LoginInterceptor.afterCompletion****拦截结束" );
    }
}
