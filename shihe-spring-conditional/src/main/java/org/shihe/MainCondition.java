package org.shihe;

import org.shihe.config.ConditionConfig;
import org.shihe.os.WindowsListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MainCondition
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 15:14
 * @Version 1.0
 */
public class MainCondition {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        WindowsListService bean = context.getBean(WindowsListService.class);
        String s = bean.showListCmd();
        System.out.println(context.getEnvironment().getProperty("os.name")
        +"系统下的查看列表命令为："
        +s);
    }
}
