package org.shihe.thread;

import javax.sound.midi.Soundbank;
import javax.xml.bind.SchemaOutputResolver;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 16:20
 * @Version 1.0
 */
public class MyThread extends Thread{
    @Override
    public synchronized void start() {
        System.out.println("start 启动一个线程");
    }

    // start()方法会在内部自动调用实例的run()方法。
    @Override
    public void run() {
        System.out.println("启动一个线程");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        myThread.run();
        myThread.start();
    }
}
