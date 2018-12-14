package com.sm.config;


import com.sm.docShare.DocShareHelper;
import com.sm.util.RedisUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("拦截器开始工作,请求url为:"+httpServletRequest.getRequestURI());
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies==null){
            logger.info("没有获取到登录信息");
            httpServletResponse.sendRedirect("../index");
            return false;
        }else {
            for (Cookie c:cookies) {
                if(DocShareHelper.token.equals(c.getName())&&redisUtil.hasKey(c.getValue())){
                    logger.info("登录信息验证成功！");
                    return true;
                }
            }
        }
        logger.info("没有获取到登录信息");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
