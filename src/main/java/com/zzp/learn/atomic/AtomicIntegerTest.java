package com.zzp.learn.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Desc atomic integer test
 * Created by zzp
 * on 2017/8/11.6:26
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
        System.out.println(ai.getAndDecrement());
    }
}
