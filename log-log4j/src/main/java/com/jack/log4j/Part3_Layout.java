package com.jack.log4j;

import org.apache.log4j.Logger;

/**
 * @Description Part3_Layout： 自定义Layout，实现自定义日志格式
 * @Author Jack
 * @Date 2024/5/2
 */
public class Part3_Layout {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("com.jack.log4j.Part3_Layout");

        for (int i = 0; i < 1000000000; i++) {
            // 日志打印，级别由低到高
            logger.trace("这是一条trace信息.");
            logger.debug("这是一条debug信息.");
            logger.info("这是一条info信息.");
            logger.warn("This is a warn message.");
            logger.error("This is an error message.");
            logger.fatal("This is a fatal message.");
        }

        // 自定义日志格式
        // 自定义日志格式，需要实现org.apache.log4j.Layout接口，并重写其format方法。
    }
}
