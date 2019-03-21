package com.sm.util;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文工具类，用以让普通类获取Spring容器中的Bean
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    private static ApplicationContext applicationContext = null;

    /**
     * 获取applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
            logger.info("applicationContext配置成功，可以通过 SpringUtil.getBean(String name)  的方式获取bean");
            String[] beans = applicationContext.getBeanDefinitionNames();
            logger.info("已加载的bean对象有："+ ArrayUtils.toString(beans));
        }
    }

    /**
     * 通过name获取 Bean
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
}
