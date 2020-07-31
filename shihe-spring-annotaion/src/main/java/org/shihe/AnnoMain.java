package org.shihe;

import org.shihe.config.AnnoConfig;
import org.shihe.service.HelloAnnotationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AnnoMain
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 15:48
 * @Version 1.0
 */
public class AnnoMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoConfig.class);

        HelloAnnotationService bean = context.getBean(HelloAnnotationService.class);
        bean.output();

        context.close();
    }
}
