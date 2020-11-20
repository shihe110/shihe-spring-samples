package org.shihe.thread;

/**
 * @ClassName MyThread4
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 16:51
 * @Version 1.0
 */
public class MyThread4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            int n = 0;
            while (! isInterrupted()){
                n ++;
                System.out.println(n + "hello");
            }
        }
    }
}
