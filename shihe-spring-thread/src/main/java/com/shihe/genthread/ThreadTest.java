package com.shihe.genthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });

        FutureTask<String> ft = new FutureTask<String>(
                () -> {
                    return "hello Callable";
                }
        );

        Thread hello = new Thread(ft, "hello");
        hello.start();
        t.start();
        String s = ft.get();
        System.out.println(s);
        t.join();


    }
}
