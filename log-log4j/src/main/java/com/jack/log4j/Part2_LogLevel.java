package com.jack.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;

/**
 * @Description
 * @Author Jack
 * @Date 2024/5/2
 */
public class Part2_LogLevel {
    public static void main(String[] args) {

        LogLog.setInternalDebugging(true);

        Logger logger = Logger.getLogger("com.jack.log4j.Part2_LogLevel");

        // 8个级别的日志
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
        logger.log(org.apache.log4j.Level.OFF, "off message");
        logger.log(org.apache.log4j.Level.FATAL, "fatal message");
        logger.log(org.apache.log4j.Level.ERROR, "error message");

    }
}
