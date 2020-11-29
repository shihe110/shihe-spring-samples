package org.shihe.pojo;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName IocTest
 * @Description TODO
 * @Author admin
 * @Date 2020-10-29 15:30
 * @Version 1.0
 */
public class IocTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*User user1 = context.getBean("user1", User.class);
        System.out.println(user1.toString());
        System.out.println("---------------------------------------------");
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2.toString());
        System.out.println("---------------------------------------------");
        User user3 = context.getBean("user3", User.class);
        System.out.println(user3.toString());

        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);

        Dog dog2 = context.getBean("dog2", Dog.class);
        System.out.println(dog2);*/
        HelloController helloController = context.getBean("helloController", HelloController.class);
        HelloService helloService = context.getBean("helloService", HelloService.class);
        System.out.println(helloService.name);
        helloController.hello();
        System.out.println(helloService.name);

    }
}
