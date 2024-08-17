package com.bite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
    private static Logger logger = LoggerFactory.getLogger(Logger.class);
    @RequestMapping("/logger")
    public String logger(){
       // System.out.println("打印日志");

        logger.info("-------要输出的日志内容-----");
        return "打印日志";
    }

    @RequestMapping("/printLog")
    public String printLog(){
        logger.trace("========trace=========");
        logger.debug("========debug=========");
        logger.info("========info=========");
        logger.warn("========warn=========");
        logger.error("========error=========");
        return "打印不同级别的日志";
    }
}
