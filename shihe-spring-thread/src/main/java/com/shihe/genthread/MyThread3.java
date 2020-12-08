package com.shihe.genthread;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        return 5;
    }
}
