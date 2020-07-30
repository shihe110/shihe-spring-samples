package org.shihe;

import org.shihe.config.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 17:05
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig bean = context.getBean(ElConfig.class);
        bean.outputResource();
        context.close();
    }
}
