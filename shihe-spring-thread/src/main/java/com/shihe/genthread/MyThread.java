package com.shihe.genthread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread，重写run，实例化对象，调用start");
    }
}
