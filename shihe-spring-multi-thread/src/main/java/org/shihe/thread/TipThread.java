package org.shihe.thread;

/**
 * @ClassName TipThread
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 9:23
 * @Version 1.0
 */
public class TipThread extends Thread{
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running){
            n++;
            System.out.println(n+"hello");
        }
    }
}
