package org.shihe.sync;

/**
 * @ClassName AddThread
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 9:53
 * @Version 1.0
 */
public class AddThread extends Thread{
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized (Counter.lock){
                Counter.count += 1;
            }
        }
    }
}
