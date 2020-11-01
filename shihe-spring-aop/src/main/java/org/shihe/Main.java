package org.shihe;

import org.shihe.aop.AopConfig;
import org.shihe.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        // spring api aop
       /* ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("applicationContext-springapi.xml");
        SpringApiServcie demoSpringApiService = c.getBean("springApiServcie", SpringApiServcie.class);
        demoSpringApiService.hello();*/

       // custom aop
        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-custom.xml");
        CustomService customService = ctx.getBean("customService", CustomService.class);
        customService.custom();*/

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        AnnotationService customService = ctx.getBean("annotationService", AnnotationService.class);
        customService.hello();

        int beanDefinitionCount = ctx.getBeanDefinitionCount();
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionCount; i++) {
            System.out.println(i + " " +beanDefinitionNames[i]);
        }

    }
}
