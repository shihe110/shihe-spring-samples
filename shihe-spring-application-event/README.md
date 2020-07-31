## Spring事件 Application Event 

spring 事件为bean与bean之间消息通信提供了支持。
当一个bean处理完一个任务后，希望另一个bean知道并能做相应的处理。
这时我们要让另一个bean监听当前bean所发送的事件。

流程：
- 1.自定义事件，继承ApplicationEvent
- 2.定义事件监听，实现ApplicationListener
- 3.使用容器发布事件

