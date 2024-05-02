package com.jack.logjul.test;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * @Description logger 父子引用测试
 * 在Java中，Logger对象支持父子引用的概念。父Logger可以通过Logger的命名层次结构传播日
 * 志记录器的配置和过滤器，而子Logger则可以继承其父Logger的配置。这使得日志记录器的配置可以在整个层次结构中传播和共享。
 * @Author Jack
 * @Date 2024/5/1
 */
public class ParentAndChildRef {
    public static void main(String[] args) {
        // 创建父子Logger对象：从下面可以看出，logger1的父Logger是null，logger2的父Logger是logger1
        Logger logger1 = Logger.getLogger("com.jack");
        Logger logger2 = Logger.getLogger("com.jack.ParentAndChildRef");

        // 子Logger继承父Logger的配置
        System.out.println(logger2.getParent() == logger1); // true：logger2继承了logger1的配置

        System.out.printf("父Logger的名称：%s\n", logger1.getParent()); // java.util.logging.LogManager$RootLogger@85ede7b
        System.out.printf("父Logger的名称：%s\n", logger1.getName()); // "com.jack"
        System.out.printf("子Logger的名称：%s\n", logger2.getName()); // "com.jack.ParentAndChildRef"
        System.out.printf("通过子Logger获取父Logger的名称：%s\n", logger2.getParent().getName()); // "com.jack"

        // 父子Logger的日志记录的好处：
        // 1、可以实现日志记录器的配置和过滤器的共享，使得日志记录的整体效果更加统一和一致
        // 2、父Logger的配置可以被子Logger继承，使得日志记录的配置更加灵活和方便
        // 3、父Logger的日志记录器可以被子Logger继承，使得日志记录的输出更加集中和清晰

    }
}
