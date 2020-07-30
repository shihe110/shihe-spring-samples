package org.shihe;

import org.shihe.config.BeanScopeConfig;
import org.shihe.service.DemoPrototypeService;
import org.shihe.service.DemoSingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 16:30
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanScopeConfig.class);

        // 分别从容器中获取两个bean比较是否相等

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

        System.out.println(p1.equals(p2));
        System.out.println(s1.equals(s2));

        context.close();
    }
}
