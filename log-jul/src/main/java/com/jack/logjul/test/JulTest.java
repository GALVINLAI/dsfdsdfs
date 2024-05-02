package com.jack.logjul.test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Description jul日志测试
 * @Author Jack
 * @Date 2024/5/1 22:00
 */
public class JulTest {

    // 创建 JUL 日志记录器：参数为当前类的全类名
    private static final Logger logger = Logger.getLogger("com.jack.JulTest");
    public static void main(String[] args) {
        // 输出不同级别的日志信息
        logger.severe("严重错误日志信息");
        logger.warning("警告日志信息");
        logger.info("普通信息日志");
        logger.config("配置信息日志");
        logger.fine("详细信息日志");
        logger.finer("更详细信息日志");
        logger.finest("非常详细信息日志");
        // 可以设置日志级别
        logger.setLevel(Level.INFO);
        logger.info("只有级别为FINE及以上的日志会被输出");
    }
}
