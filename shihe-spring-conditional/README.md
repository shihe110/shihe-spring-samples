## spring条件注解@Conditional

@Conditional根据满足某个特定条件创建一个特定的bean。例如，当某个jar包在一个类路径下时，自动配置一个或多个bean。
或者只有某个bean被创建时才会创建另外一个bean。总的来说。就是根据特定条件来控制bean的创建行为。springboot的自动配置就是基于条件注解实现的。

## 示例，通过实现Condition接口，在不同操作系统条件下，输出不同命令。windows-dir Linux-ls


### 1.定义判断条件
```java
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
```
### 2.适配不同系统的bean
```java
public interface ListService {
    public String showListCmd();
}
// Windows下为dir
public class WindowsListService implements ListService{
    public String showListCmd() {
        return "dir";
    }
}
// linux下为ls命令
public class LinuxListService implements ListService{
    public String showListCmd() {
        return "ls";
    }
}

```
### 3.配置类
```java
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    WindowsListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    LinuxListService linuxListService(){
        return new LinuxListService();
    }
}
```
### 4.运行测试
```java
public class MainCondition {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService bean = context.getBean(ListService.class);
        String s = bean.showListCmd();
        System.out.println(context.getEnvironment().getProperty("os.name")
        +"系统下的查看列表命令为："
        +s);
    }
}
```
