package com.jack.jul.test;

import java.io.IOException;
import java.util.logging.*;

/**
 * @Description 输出到文件
 * @Author Jack
 * @Date 2024/5/1
 */
public class OutputToFile {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("com.jack.OutputToFile");
        // 将默认的日志打印方式关闭，这样打印日志就不会按照父longer的日志记录器的配置方式进行
        logger.setUseParentHandlers(false);
        // 文件处理器
        FileHandler fileHandler = new FileHandler("D:\\workspace\\study-log\\log-jul\\log\\output.log");
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(simpleFormatter);
        // 可以同时添加多个日志处理器，比如控制台输出、邮件输出等
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);


        logger.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);
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
