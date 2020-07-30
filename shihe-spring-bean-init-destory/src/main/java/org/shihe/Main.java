package org.shihe;

import org.shihe.bean.DemoBeanService;
import org.shihe.config.DemoInitDesConfig;
import org.shihe.jsr250.DemoJSR250Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 17:39
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoInitDesConfig.class);
        DemoBeanService bean = context.getBean(DemoBeanService.class);
        DemoJSR250Service bean1 = context.getBean(DemoJSR250Service.class);

        context.close();
    }
}
