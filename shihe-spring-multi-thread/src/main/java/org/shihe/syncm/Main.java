package org.shihe.syncm;

import java.util.zip.CheckedOutputStream;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 10:42
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        // 对c1进行操作的线程:
        new Thread(() -> {
            c1.add();
        }).start();
        new Thread(() -> {
            c1.dec();
        }).start();
    }
}
