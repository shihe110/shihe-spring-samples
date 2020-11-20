package org.shihe.thread;

/**
 * @ClassName MyThread4
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 16:51
 * @Version 1.0
 */
public class MyThread5 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1);
        myThread.running = false;
    }

    static class MyThread extends Thread{
        public volatile boolean running = true;
        public void run(){
            int n = 0;
            while (running){
                n ++;
                System.out.println(n+"hello");
            }
            System.out.println("end");
        }
    }
}
