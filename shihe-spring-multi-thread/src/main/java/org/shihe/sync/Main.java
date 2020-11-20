package org.shihe.sync;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 9:55
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();

        add.start();
        dec.start();

        add.join();// 等add结束
        dec.join();// 等dec结束
        // 打印结果
        System.out.println(Counter.count);
    }
}
