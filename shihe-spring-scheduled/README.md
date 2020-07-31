## spring scheduling 计划任务

### spring计划任务主要用到的两个注解

### 1.@EnableScheduling 开启计划任务

### 2.@Scheduled 声明计划任务
包括：cron表达式、fixDelay、fixRate等方式

## 示例

### 1.新建计划任务类
```java
@Service
public class SchedulingService {

    @Scheduled(fixedDelay = 5000)//执行完后隔5秒再执行
    public void fixDelayMethod(){
        System.out.println("fixDelay方式计划任务");
    }

    @Scheduled(fixedRate = 5000)// 每5秒执行一次
    public void fixRateMethod(){
        System.out.println("fixRate方式计划任务");
    }

    @Scheduled(cron = "0/5 * * * * ? ")// 表示没隔5秒执行一次
    public void cronMethod(){
        System.out.println("cron方式计划任务");
    }
}
```

### 2.配置计划任务
```java
@Configuration
@EnableScheduling // 开启计划任务
@ComponentScan(basePackages = "org.shihe")
public class SchedulingConfig {
}
```

### 3.运行测试
```java
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulingConfig.class);

        SchedulingService bean = context.getBean(SchedulingService.class);
        bean.fixRateMethod();
        bean.fixDelayMethod();
        bean.cronMethod();

        context.close();
    }
}
```
