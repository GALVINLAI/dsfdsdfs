package com.jack.log4j;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @Description 入门测试 Log4j
 * @Author Jack
 * @Date 2024/5/2
 */
public class Part1_Log4j {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Part1_Log4j.class);

        /**
         * 首先需要加载初始化配置，要不然会报如下警告信息：
         *  log4j:WARN No appenders could be found for logger (com.jack.log4j.Part1_Log4j).
         * log4j:WARN Please initialize the log4j system properly.
         * log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
        */
        BasicConfigurator.configure();
        // 打印不同级别的日志信息，从高到低分别8个级别，分别为：FATAL、ERROR、WARN、INFO、DEBUG、TRACE、ALL、OFF
        // 设置日志级别
        logger.setLevel(Level.DEBUG);
        logger.fatal("这是致命错误信息.");
        logger.error("这是错误信息.");
        logger.warn("这是警告信息.");
        logger.info("这是一般信息.");
        logger.debug("这是调试信息.");
        logger.trace("这是追踪信息.");
        logger.log(org.apache.log4j.Level.ALL, "这是所有级别的信息.");
        logger.log(org.apache.log4j.Level.OFF, "这是关闭日志信息.");
    }
}
