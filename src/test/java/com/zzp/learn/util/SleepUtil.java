package com.zzp.learn.util;

/**
 * Desc
 * Created by zzp
 * on 2017/8/4.7:30
 */
public class SleepUtil {

    public static void second(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
