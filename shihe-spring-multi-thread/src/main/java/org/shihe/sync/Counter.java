package org.shihe.sync;

/**
 * @ClassName Counter
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 9:53
 * @Version 1.0
 */
public class Counter {
    public static Object lock = new Object();
    public static int count = 0;
}
