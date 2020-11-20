package org.shihe.thread;

/**
 * @ClassName MyThread2
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 16:26
 * @Version 1.0
 */
public class MyThread2 implements Runnable{
    public void run() {
        System.out.println("启动一个线程runable");
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.run();
    }
}
