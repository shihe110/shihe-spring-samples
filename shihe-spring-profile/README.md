## 使用profile实现对不同环境不同配置的支持

### 实现方式

- 1.设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。
在开发中使用@Profile注解或方法，根据实际情况实例化对应的bean。

- 2.通过设定jvm的spring.profiles.active参数设置环境变量。

- 3.Web项目设置在Servlet的context parameter中。

