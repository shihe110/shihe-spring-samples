## spring Aware感知接口获取接口提供的服务

## 测试获取BeanNameAware服务及ResourceLoaderAware资源加载服务，示例。

### 在resource下，新建test.txt文件并添加信息
```java
hello aware
```

### 实现感知接口
```java
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader resourceLoader;

    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("bean的名称为"+beanName);

        Resource resource = resourceLoader.getResource("test.txt");
        try {
            InputStream inputStream = resource.getInputStream();
            System.out.println("文件内容为： "+IOUtils.toString(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

### 配置
```java
@Configuration
@ComponentScan(basePackages = "org.shihe")
public class AwareConfig {
}
```

### 运行测试

```java
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService bean = context.getBean(AwareService.class);
        bean.outputResult();
        
        context.close();
    }
}
```

