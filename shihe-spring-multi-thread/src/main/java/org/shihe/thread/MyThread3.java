package org.shihe.thread;

import static sun.misc.PostVMInitHook.run;

/**
 * @ClassName MyThread3
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 16:41
 * @Version 1.0
 * 该示例有两个线程,一个主线程一个t线程，join()指线程加入先执行完毕后再执行主线程
 */
public class MyThread3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
                System.out.println("hello");
        });
        System.out.println("主线程-start");
        t.start();
        t.join();
        System.out.println("主线程-end");
    }
}
