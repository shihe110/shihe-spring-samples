package org.shihe.thread;

import sun.awt.windows.ThemeReader;

/**
 * @ClassName MyThread4
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 16:51
 * @Version 1.0
 */
public class MyThread6 {
    public static void main(String[] args) throws InterruptedException {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.run();
        dec.run();
        add.join();
        dec.join();
        System.out.println(Counter.count);

    }

    static class Counter {
        public static final Object lock = new Object();
        public static int count = 0;
    }

    static class AddThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (Counter.lock){
                    System.out.println(i);
                    Counter.count += 1;
                }
            }
        }
    }

    static class DecThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (Counter.lock){
                    Counter.count -=1;
                }
            }
        }
    }
}

