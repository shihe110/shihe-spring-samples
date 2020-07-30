package org.shihe.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName DemoJSR250Service
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 17:33
 * @Version 1.0
 */
public class DemoJSR250Service {

    @PostConstruct
    public void init(){
        System.out.println("JSR250 初始化");
    }

    public DemoJSR250Service() {
        super();
        System.out.println("jsr250构造函数初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JSR250 销毁");
    }
}
