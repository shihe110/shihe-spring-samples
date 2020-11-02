package com.shihe;

import com.shihe.service.HelloService;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-10-30 17:38
 * @Version 1.0
 */
public class Main {
     public static void main(String[] args) {
          ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
          HelloService helloService = context.getBean("helloService", HelloService.class);
          helloService.hello();
     }
}
