## Get Started 开始使用

[nimble-orm](https://github.com/pugwoo/nimble-orm)是基于Spring JDBC的零入侵封装，因此在Spring Boot中，它依赖于spring-boot-starter-jdbc，请确保项目自行引入该依赖并正确配置了数据库连接。

然后，在项目中maven引入依赖：

```xml
<dependency>
	<groupId>com.pugwoo</groupId>
	<artifactId>nimbleorm-spring-boot-starter</artifactId>
	<version>0.9.7</version>
</dependency>
```

就可以开始使用了。详细例子见该git的nimbleorm-spring-boot-starter-demo目录，以及nimble-orm项目更详细的文档。

默认情况下不需要配置参数就可以使用了，如有需要，可以配置一下参数：
```yaml
nimbleorm:
  timeoutWarningValve: 1000 # 慢SQL阈值，单位毫秒，默认1000
  maxPageSize: 1000 # 全局设置最大每页个数，默认不限制
  isPrimaryBean: false # 是否是Primary的Bean，默认不是
```


说明：当Spring有多个数据源时，该starter会默认（暂无法配置修改）使用Primary主数据源，请确保有主数据源。如果其它数据源也需要配置使用nimble-orm，则需要单独手动再配置其他的。

## changelog

- v0.0.1 基本功能完成
- v0.0.2 nimbleorm升级到0.8.7，springboot升级到2.0.4
- v0.9.0 nimbleorm升级到0.9.0，以后版本和nimble-orm保持一致
