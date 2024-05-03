# study-log4j

## 介绍
Log4j 是一个流行的 Java 日志框架，用于在应用程序中记录日志消息。Log4j 允许开发人员控制日志记录的格式和位置，并能够根据日志级别过滤和处理日志消息。

## 日志级别
- ALL: 这是最低的日志级别，表示日志系统应记录所有消息。
- TRACE: 这个级别被用于追踪程序的详细执行过程。通常用于故障排除和调试。
- DEBUG: DEBUG 级别用于记录调试信息，例如变量的值、方法的执行等。通常用于开发和测试环境。
- INFO: INFO 级别表示用于记录关键操作和重要事件，例如启动、关闭、关键操作等。
- WARN: WARN 级别表示潜在的问题，这些问题不会导致程序失败，但可能需要关注。
- ERROR: ERROR 级别用于记录可能导致程序失败的错误情况，但程序仍然可以继续执行。
- FATAL: FATAL 级别用于记录严重错误，这些错误会导致程序无法继续执行。
- OFF: 这是最高的日志级别，表示日志系统不应记录任何消息。

## 日志配置
Log4j 的配置文件 log4j.properties 位于 classpath 下，
可以通过 JVM 参数 -Dlog4j.configuration=file:log4j.properties 来指定配置文件的位置。

### 组成格式
- Logger: 日志记录器，用于记录日志消息。
- Appender: 日志输出控制，用于指定日志消息的输出目的地。
- Layout: 日志格式化器，用于指定日志消息的输出格式。
### 源码解析
``` java 
 step1 LogManager.getLogger(clazz.getName());
  // 常量定义，默认配置文件名：log4j.properties（最常用的配置文件）
  static public final String DEFAULT_CONFIGURATION_FILE = "log4j.properties";
  static final String DEFAULT_XML_CONFIGURATION_FILE = "log4j.xml";  
  /**
   * @deprecated This variable is for internal use only. It will
   * become private in future versions.
   * */
  static final public String DEFAULT_CONFIGURATION_KEY="log4j.configuration";
  /**
   * @deprecated This variable is for internal use only. It will
   * become private in future versions.
   * */
  static final public String CONFIGURATOR_CLASS_KEY="log4j.configuratorClass";
  /**
  * @deprecated This variable is for internal use only. It will
  * become private in future versions.
  */
  public static final String DEFAULT_INIT_OVERRIDE_KEY = "log4j.defaultInitOverride";
```

``` java 
  // step2 读取配置文件,在LogManager类中的静态代码块中读取配置文件，默认从classpath下读取配置文件
  // static public final String DEFAULT_CONFIGURATION_FILE = "log4j.properties";
  if(url == null) {
	  url = Loader.getResource(DEFAULT_CONFIGURATION_FILE);
	}
```

``` java 
  // step3 加载配置文件
  OptionConverter.selectAndConfigure(url, configuratorClassName,LogManager.getLoggerRepository());
  // OptionConverter#selectAndConfigure
   configurator = new PropertyConfigurator();
  // PropertyConfigurator 包含log4j.properties配置文件的解析逻辑及其默认配置
  // 下面的必须配置
  static final String ROOT_LOGGER_PREFIX   = "log4j.rootLogger";
  static final String      APPENDER_PREFIX = "log4j.appender.";
  // 需要自定义appender的配置
  String prefix = APPENDER_PREFIX + appenderName;
```
``` java 
   // layout 配置
   // PatternLayout 的核心方法
   public void setConversionPattern(String conversionPattern) {
    pattern = conversionPattern;
    head = createPatternParser(conversionPattern).parse();
  }
```

``` java 
   // RollingFileAppender: 日志文件按照大小滚动，达到一定大小后，自动生成新的日志文件 按照时间顺序，保留新的，替换旧的
   // DailyRollingFileAppender: 日志文件按照日期滚动，每天生成新的日志文件
```

 

 

 