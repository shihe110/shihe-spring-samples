package org.shihe.thread;

/**
 * @ClassName MyThreadInterrupt
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 8:36
 * @Version 1.0
 */
public class MyThreadInterrupt extends Thread{
    @Override
    public void run() {
        HelloThread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {

            System.out.println("中断");
        }
//        hello.interrupt();

    }
}
