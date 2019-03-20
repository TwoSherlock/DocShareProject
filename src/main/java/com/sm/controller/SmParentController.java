package com.sm.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmParentController {
    public static final Logger logger = LoggerFactory.getLogger(SmParentController.class);
    public final Gson gson = new Gson();

    /**
     * 打印出类的日志信息,info级别
     * @param logMsg
     */
    public void logInfo(String logMsg){
        String className = this.getClass().getName();
        logger.info(className+"："+logMsg);
    }

    /**
     * 打印出类的日志信息,error级别
     * @param logMsg
     */
    public void logError(String logMsg){
        String className = this.getClass().getName();
        logger.error(className+"：!ERROR;发生异常"+logMsg);
    }
}
