//package com.sm.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.servlet.config.annotation.*;
//
//@Configuration
//public class SpringMVCConfig extends WebMvcConfigurationSupport {
//
//    //自定义mvc相关
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController( "/" ).setViewName( "forward:login" );
//        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
//        super.addViewControllers( registry );
//    }
//}
