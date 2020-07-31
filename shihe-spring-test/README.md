## spring对测试的支持

spring提供一个SPringJUnitClassRunner类，他提供了
Spring TestContext Framework的功能。通过@ContextConfiguration来配置
Application Context，通过@ActiveProfiles确定活动profile。

## demo
```java
public class DemoBean {

    private String name;

    public DemoBean(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
// 配置
@Configuration
public class DemoCofig {
    @Bean
    @Profile("dev")
    DemoBean demoBeanDev(){
        return new DemoBean("dev");
    }
    @Bean
    @Profile("pro")
    DemoBean demoBeanPro(){
        return new DemoBean("pro");
    }
}

```
## 运行测试
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoCofig.class)
@ActiveProfiles("pro")
public class DemoTest {

    @Autowired
    private DemoBean demoBean;

    @Test
    public void test(){
        String ex = "pro";
        String name = demoBean.getName();
        Assert.assertEquals(ex,name);
    }
}
```



