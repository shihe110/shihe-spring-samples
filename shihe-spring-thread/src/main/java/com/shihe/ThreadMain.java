package com.shihe;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        for (int i = 0; i < 5; i++) {
            ThreadService threadService = context.getBean("threadService", ThreadService.class);
            threadService.run();
        }

    }
}
