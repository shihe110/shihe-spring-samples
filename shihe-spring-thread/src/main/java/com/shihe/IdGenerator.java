package com.shihe;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName IdGenerator
 * @Description TODO
 * @Author admin
 * @Date 2020-11-02 16:01
 * @Version 1.0
 */
public class IdGenerator {
    AtomicLong id = new AtomicLong(0);
    public long getNextId(){
        long l = id.incrementAndGet();
        return l;
    }
}
