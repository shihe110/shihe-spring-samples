## spring aop 注解式拦截和方法规则式拦截示例

- 1.添加aop和aspectj依赖
- 2.编写拦截规则注解
- 3.编写使用注解的被拦截类
- 4.编写使用方法规则被拦截类
- 5.编写切面
- 6.配置类
- 7.运行测试

### 切面类LogAspect

- 1.通过@Aspect注解声明一个切面
- 2.通过@Component让此切面成为spring容器管理的bean
- 3.通过@PointCut注解声明切点
- 4.通过@After注解声明一个advice，并使用@PointCut定义的切点
- 5.通过反射获取注解上的属性，然后做想要的相关操作
- 6.通过@Before注解声明一个advice，并直接使用方法拦截规则作为参数