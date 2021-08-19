# micro-boot

micro-boot 参考并继承了spring-boot的设计理念，封装了平时开发过程中经常需要的公共配置，并可以轻易接入其他开源项目。它可以帮助你以最小的配置迅速启动一个springboot应用，并有以下特性：

- 统一的请求接收响应与错误码，全局异常处理
- 场景丰富的实体类型，大量的通用方法(基于mybatis-plus)
- 提供基础的日志配置，实现控制台与文件日志输出
- 提供统一的认证与授权（基于keycloak，待我整理下push上来）
- starter形式接入任何其他项目并做自动配置

## 安装与配置

pom.xml中配置如下

```xml

<parent>
    <groupId>com.microframework.boot</groupId>
    <artifactId>micro-boot-starter-parent</artifactId>
    <version>${version}</version>
</parent>
```

按需引入依赖

```xml

<dependencies>
    <dependency>
        <groupId>com.microframework.boot</groupId>
        <artifactId>micro-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.microframework.boot</groupId>
        <artifactId>micro-boot-starter-db</artifactId>
    </dependency>
</dependencies>
```

用法与spring-boot完全相同 

## Modules
### micro-boot
主库，加入大量我们自己的配置与组件，包括：

- 统一的请求接收响应与错误码
- 场景丰富的实体类型，大量的通用方法(基于mybatis-plus)
- 提供基础的日志配置，实现控制台与文件日志输出
- 提供统一的认证与授权（基于keycloak）

### micro-boot-autoconfigure
自动配置，充分利用了spring-boot的自动配置原理，针对我们的框架引入自动配置，是实现零配置的关键module，根据上下文来判断是否创建bean来注入容器 
  
### micro-boot-starters
继承于spring-boot-starter的设计，实现一键引入micro-boot环境，无需分辨引入各种复杂的依赖，按需引入starter。