## 组合注解和元注解

注解的注解称之为元注解。被注解的注解称之为组合注解。组合注解具备元注解功能。@Configuration就是组合了@Component的注解。

如@Configuration和ComponentScan经常一起使用。所以可以将这两个元注解组成一个组合注解。

## 示例

### 定义组合注解
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface ConfigScan {

    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};
}
```
### 配置
```java
@ConfigScan("org.shihe")
public class AnnoConfig {
}
```
### 运行测试
```java
// 测试service类
@Service
public class HelloAnnotationService {

    public void output(){
        System.out.println("从组合注解获取该bean");
    }
}

public class AnnoMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoConfig.class);

        HelloAnnotationService bean = context.getBean(HelloAnnotationService.class);
        bean.output();

        context.close();
    }
}
```



