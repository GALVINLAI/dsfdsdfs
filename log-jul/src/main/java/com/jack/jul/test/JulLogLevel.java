package com.jack.jul.test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Description 日志级别
 * 系统默认级别：INFO，级别低于INFO的日志不会输出
 * 日志级别：SEVERE、WARNING、INFO、FINE、FINER、FINEST
 * @Author Jack
 * @Date 2024/5/1
 */
public class JulLogLevel {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("com.jack.JulLogLevel");

        // 设置日志级别为all，输出所有日志信息，这样设置不起作用，需要设置具体的日志处理器
        logger.setLevel(Level.ALL);

        // servere level message：严重错误
        logger.severe("This is a severe message.");

        // warning level message：警告信息
        logger.warning("This is a warning message.");

        // info level message：一般信息
        logger.info("This is an info message.");

        // fine level message：细节信息
        logger.fine("This is a fine message.");

        // finer level message：更细节信息
        logger.finer("This is a finer message.");

        // finest level message：最细节信息
        logger.finest("This is a finest message.");
    }
}
