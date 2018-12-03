package com.sm.config;


import com.sm.docShare.DocShareHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检测拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("------------------拦截器开始工作---------------------");
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies==null){
            return false;//跳转到登录
        }else {
//            for (Cookie c:cookies) {
//                if(DocShareHelper.token.equals(c.getName())&&){
//
//                }
//            }
        }
        return true;//不拦截
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
