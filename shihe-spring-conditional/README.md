## spring条件注解@Conditional

@Conditional根据满足某个特定条件创建一个特定的bean。例如，当某个jar包在一个类路径下时，自动配置一个或多个bean。
或者只有某个bean被创建时才会创建另外一个bean。总的来说。就是根据特定条件来控制bean的创建行为。springboot的自动配置就是基于条件注解实现的。

## 示例，通过实现Condition接口，在不同操作系统条件下，输出不同命令。windows-dir Linux-ls

### 1.定义判断条件

### 2.适配不同系统的bean

### 3.配置类

### 4.运行测试

