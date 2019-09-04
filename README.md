# nimbleorm-spring-boot-starter
spring boot starter for nimble-orm

## Get Started 开始使用

[nimble-orm](https://github.com/pugwoo/nimble-orm)是基于Spring JDBC的零入侵封装，因此在Spring Boot中，它依赖于spring-boot-starter-jdbc，请确保项目自行引入该依赖并正确配置了数据库连接。

然后，在项目中maven引入依赖：

```xml
<dependency>
	<groupId>com.pugwoo</groupId>
	<artifactId>nimbleorm-spring-boot-starter</artifactId>
	<version>0.9.4</version>
</dependency>
```

就可以开始使用了。详细例子见该git的nimbleorm-spring-boot-starter-demo目录，已经nimble-orm项目更详细的文档。

说明：当Spring有多个数据源时，该starter会默认（暂无法配置修改）使用Primary主数据源，请确保有主数据源。

## changelog

- v0.0.1 基本功能完成
- v0.0.2 nimbleorm升级到0.8.7，springboot升级到2.0.4
- v0.9.0 nimbleorm升级到0.9.0，以后版本和nimble-orm保持一致
