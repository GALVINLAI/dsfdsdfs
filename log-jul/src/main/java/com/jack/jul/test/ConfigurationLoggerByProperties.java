package com.jack.jul.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @Description 通过properties文件配置日志
 * @Author Jack
 * @Date 2024/5/2
 */
public class ConfigurationLoggerByProperties {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("log-jul/src/main/resources/logging.properties");
        LogManager logManager = LogManager.getLogManager();

        logManager.readConfiguration(inputStream);
        Logger logger = Logger.getLogger("com.jack.logjul.test.ConfigurationLoggerByProperties");

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
