package org.shihe.bean;

/**
 * @ClassName DemoBeanService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 17:30
 * @Version 1.0
 */
public class DemoBeanService {

    public void init(){
        System.out.println("@Bean 的 init");
    }

    public DemoBeanService() {
        super();
        System.out.println("@Bean初始化构造函数");
    }

    public void destroy(){
        System.out.println("@Bean 的 destroy");
    }
}
