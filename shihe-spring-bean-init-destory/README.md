## bean的初始化和销毁的两种方式

- 1.java配置方式：@Bean注解的initMethod和destroyMethod
- 2.注解方式：JSR-250的@PostConstruct和@PreDestory

```java
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>jsr250-api</artifactId>
    <version>1.0-20050927.133100</version>
</dependency>
```
### JSR-250
```java
public class DemoJSR250Service {

    @PostConstruct
    public void init(){
        System.out.println("JSR250 初始化");
    }

    public DemoJSR250Service() {
        super();
        System.out.println("jsr250构造函数初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JSR250 销毁");
    }
}
```

### @Bean形式
```java
public class DemoBeanService {

    public void init(){
        System.out.println("@Bean 的 init");
    }

    public DemoBeanService() {
        super();
        System.out.println("@Bean初始化构造函数");
    }

    public void destroy(){
        System.out.println("@Bean 的 destroy");
    }
}
```
### 配置bean
```java
@Configuration
@ComponentScan(basePackages = "org.shihe")
public class DemoInitDesConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    DemoBeanService demoBeanService(){
        return new DemoBeanService();
    }

    @Bean
    DemoJSR250Service demoJSR250Service(){
        return new DemoJSR250Service();
    }
}

```

## 运行测试
```java
 public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoInitDesConfig.class);
        DemoBeanService bean = context.getBean(DemoBeanService.class);
        DemoJSR250Service bean1 = context.getBean(DemoJSR250Service.class);

        context.close();
    }
```