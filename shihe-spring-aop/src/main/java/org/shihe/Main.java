package org.shihe;

import org.shihe.aop.AopConfig;
import org.shihe.service.DemoAnnotationService;
import org.shihe.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Mian
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 15:45
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoMethodService bean = context.getBean(DemoMethodService.class);
        DemoAnnotationService bean1 = context.getBean(DemoAnnotationService.class);
        bean.add();
        bean1.add();
        context.close();
    }
}
