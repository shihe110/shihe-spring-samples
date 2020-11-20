package org.shihe;

import org.shihe.thread.MyThreadInterrupt;
import org.shihe.thread.TipThread;

/**
 * @ClassName MainInterrupt
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 8:37
 * @Version 1.0
 */
public class MainInterrupt {
    public static void main(String[] args) throws InterruptedException {
       /* MyThreadInterrupt in = new MyThreadInterrupt();
        in.start();
        Thread.sleep(1000);
        in.interrupt();
        in.join();
        System.out.println("结束");*/

        TipThread tipThread = new TipThread();
        tipThread.start();

        Thread.sleep(1);
        tipThread.running = false;

    }
}
