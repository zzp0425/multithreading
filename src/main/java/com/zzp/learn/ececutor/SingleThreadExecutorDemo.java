package com.zzp.learn.ececutor;

import java.util.concurrent.*;

/**
 * Desc
 * Created by zzp
 * on 2017/8/21.23:12
 */
public class SingleThreadExecutorDemo {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        long time = 6;
        for (int i = 0; i < 100; i++) {
            executor.schedule(() -> System.out.println("a")
            , time * i, TimeUnit.SECONDS);
        }
    }

}
