package com.jack.jul.test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @Description 定义日志级别
 * @Author Jack
 * @Date 2024/5/1
 */
public class DefineLogLevel {
    public static void main(String[] args) {
        // 定义日志记录器
        Logger logger = Logger.getLogger("com.jack.DefineLogLevel");

        // 将默认的日志打印方式关闭，这样打印日志就不会按照父longer的日志记录器的配置方式进行
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 格式化日志输出
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);

        // 添加 ConsoleHandler 到日志记录器
        logger.addHandler(consoleHandler);

        //需要将日志记录器和处理器的日志分别统一设置级别，才会显示不同级别的日志
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

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
