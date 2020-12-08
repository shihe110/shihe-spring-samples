package com.shihe;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class ThreadService extends Thread{

    private int a = 2;

    private static int b = 3;

    private static final int c = 4;

    ThreadLocal<Integer> tl = new ThreadLocal();

    void hello(){
        System.out.println(++a+"int a");
        System.out.println(++b+"static int b");
        System.out.println(c+"static final intt c");
        System.out.println("========================");
    }

    @Override
    public void run() {
        System.out.println(++a+"int a");
        System.out.println(++b+"static int b");
        System.out.println(c+"static final intt c");
        System.out.println(tl.get());
        System.out.println("========================");
    }
}
