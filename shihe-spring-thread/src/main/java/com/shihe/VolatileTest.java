package com.shihe;

public class VolatileTest {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        System.out.println(race+"--");
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    System.out.println(race);
                    increase();
                }
            });
            threads[i].start();
        }
        /*while (Thread.activeCount()>1){
            Thread.yield();
            System.out.println("===");
        }*/
        System.out.println(race+"==");
    }
}
