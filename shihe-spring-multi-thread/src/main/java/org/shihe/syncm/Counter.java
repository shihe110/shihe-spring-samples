package org.shihe.syncm;

/**
 * @ClassName Counter
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 10:41
 * @Version 1.0
 */
public class Counter {

    public static int count = 0;

    public void add(){
        synchronized (this){
            count+=1;
        }
    }

    public void dec(){
        synchronized (this){
            count-=1;
        }
    }

    public int get(){
        return count;
    }


}
