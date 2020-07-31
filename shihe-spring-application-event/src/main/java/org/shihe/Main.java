package org.shihe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:25
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublish bean = context.getBean(DemoPublish.class);
        bean.publish("事件发布");

        context.close();
    }
}
