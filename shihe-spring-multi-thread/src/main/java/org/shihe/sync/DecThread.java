package org.shihe.sync;

/**
 * @ClassName DecThread
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 9:54
 * @Version 1.0
 */
public class DecThread extends Thread{
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized (Counter.lock){
            Counter.count -= 1;
            }
        }
    }
}
