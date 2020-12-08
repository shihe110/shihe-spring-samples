package com.shihe.genthread;

public class MyThread2 implements Runnable {
    public void run() {
        System.out.println("实例化Thread，传入实现Runable实例，调用start");
    }
}
