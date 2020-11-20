package org.shihe.thread;

/**
 * @ClassName HelloThread
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 8:56
 * @Version 1.0
 */
public class HelloThread extends Thread{

    @Override
    public void run() {
        int n =0;
        while (!isInterrupted()){
            n++;
            System.out.println(n +"hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
