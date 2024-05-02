# log-jul

## 介绍
JUL全称 Java Util Logging，它是java原生的日志框架，使用时不需要另外引用第三方的类库，相对其他的框架使用方便，学习简单，主要是使用在小型应用中。
## 组件介绍
· Logger：被称为记录器，应用程序通过获取Logger对象，抵用其API来发布日志信息。Logger通常被认为是访问日志系统的入口程序。

· Handler：处理器，每个Logger都会关联一个或者是一组Handler，Logger会将日志交给关联的Handler去做处理，由Handler负责将日志做记录。Handler具体实现了日志的输出位置，比如可以输出到控制台或者是文件中等等。

· Filter：过滤器，根据需要定制哪些信息会被记录，哪些信息会被略过。

· Formatter：格式化组件，它负责对日志中的数据和信息进行转换和格式化，所以它决定了我们输出日志最终的形式。

· Level：日志的输出级别，每条日志消息都有一个关联的级别。我们根据输出级别的设置，用来展现最终所呈现的日志信息。根据不同的需求，去设置不同的级别。
 
## 日志级别
JUL定义了5个日志级别，分别为：
- SEVERE：严重错误，表示程序中无法继续运行。
- WARNING：警告信息，表示程序可以继续运行，但是有潜在的风险。
- INFO：一般信息，表示程序的运行状态。
- FINE：调试信息，表示程序的运行状态的细节。
- FINER：更细致的调试信息。
- FINEST：最细致的调试信息。

## 日志处理器
JUL 提供了多种日志处理器，常见的包括：
- ConsoleHandler：将日志输出到控制台。
- FileHandler：将日志输出到文件。
- SocketHandler：将日志输出到网络。
- MemoryHandler：将日志输出到内存中。
- SMTPHandler：将日志发送到邮件。
- DBHandler：将日志存储到数据库。

## 自定义的Logger
JUL允许开发人员自定义Logger，只需要继承Logger类，并实现自己的日志处理逻辑即可。
自定义的Logger 有一个顶层的RootLogger，如java.util.logging.LogManager$RootLogger@85ede7b，它是所有Logger的父类。

## 日志管理器初始化

· 记录应用程序的活动: JUL 允许开发人员记录应用程序在运行时的各种活动，包括信息、警告和严重错误。通过记录这些信息，开发人员可以更好地了解应用程序在不同情况下的行为。

· 调试和故障排除: 通过记录不同级别的消息，如信息、警告和错误，开发人员可以有效地进行调试和故障排除。这有助于识别问题并解决应用程序中的 bug。

· 日志级别控制: JUL 允许开发人员根据需要设置不同的日志级别，以便根据需要记录不同级别的消息。例如，可以将日志级别设置为仅记录严重错误，或者同时记录信息、警告和错误。

· 集成和标准化: 作为 Java 平台的官方日志记录工具，JUL 能够与其他 Java 标准库和框架进行良好集成，为开发人员提供标准化的日志记录解决方案。

JUL日志管理器的初始化，需要在代码中调用静态方法 
`LogManager.getLogManager().readConfiguration()` 来读取配置文件，
配置文件的位置一般为 `logging.properties` 文件。
· 默认读取 'JAVA_HOME/lib/logging.properties' 文件

## 日志输出
JUL日志输出，需要通过Logger对象来完成，Logger对象可以通过调用LoggerFactory.getLogger()方法来获取。

1. 输出普通信息：
``` java
Logger logger = LoggerFactory.getLogger(getClass());
logger.info("This is a normal message.");
```
2. 输出异常信息：
``` java
try {
    // some code
} catch (Exception e) {
    logger.severe("An exception occurred: " + e.getMessage());
}
```
3. 输出带参数的日志信息：
``` java
String name = "John";
int age = 30;
logger.info("User {0} is {1} years old.", name, age);
```
4. 输出带 Throwable 的异常信息：
``` java
try {
    // some code
} catch (Exception e) {
    logger.log(Level.SEVERE, "An exception occurred: " + e.getMessage(), e);
}
```

## 日志配置文件
日志配置文件 `logging.properties` 的格式如下：
以上所有的配置相关的操作，都是以java硬编码的形式进行的我们可以使用更加清晰，更加专业的一种做法，就是使用配置文件，
如果我们没有自己添加配置文件，则会使用系统默认的配置文件这个配置文件：
``` java
owner.readPrimordialConfiguration();
readConfiguration();
java.home --> 找到jre文件夹 --> lib --> logging.properties
```

## 总结（原理解析）
1. 初始化logmanager：
   a. 读取配置文件：LogManager.getLogManager().readConfiguration()
   b. 添加logger 到 logmanager：owner.rootLogger = owner.new RootLogger(); owner.addLogger(owner.rootLogger); 
2. 从单例的LogManager中获取logger 
3. 设置日志级别，日志处理器，日志格式等，使用到了LogRecord类 
4. Filter作为过滤器提供了日志级别之外更细粒度的控制 
5. Handler作为日志处理器，负责日志的输出，比如控制台，文件，数据库等
6. Formatter作为日志格式化器，负责日志的格式化，比如日志输出的格式，时间的格式等









