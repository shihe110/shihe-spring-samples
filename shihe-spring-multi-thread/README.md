## Spring Multi Thread - 多线程

spring通过任务执行器（TaskExecutor）来实现多线程和并发编程。使用线程池执行器（ThreadPoolTaskExecutor）可实现一个基于线程池的TaskExecutor。实际开发任务中，一般是异步非阻塞的，所以我们要在配置类中通过@EnableAsync注解开启对异步任务的支持，并通过在实际执行的bean的方法中使用@Async注解来声明其是一个异步任务。

## @Async
注解在方法上，表明该方法是异步方法。
如果注解在类上，则表明该类的所有方法都是异步方法，方法自动被注入使用ThreadPoolTaskExecutor作为（TaskEx）执行器。


## 配置开启异步任务
```java
@Configuration
@ComponentScan(basePackages = "org.shihe")
@EnableAsync // 开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {

    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return null;
    }
}

```

## 定义异步任务

```java
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1:"+(i+1));
    }
}
```

## 运行测试

```java
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            bean.executeAsyncTask(i);
            bean.executeAsyncTaskPlus(i);
        }

        context.close();

    }
}
```