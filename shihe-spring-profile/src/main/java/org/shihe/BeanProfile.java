package org.shihe;

import org.shihe.env.bean.DemoBean;
import org.shihe.env.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 18:03
 * @Version 1.0
 */
public class BeanProfile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 先设置Active
        context.getEnvironment().setActiveProfiles("pro");
        // 后注册配置类
        context.register(ProfileConfig.class);
        // 刷新容器
        context.refresh();

        DemoBean bean = context.getBean(DemoBean.class);
        System.out.println(bean.getBeanName());

        context.close();

    }
}
