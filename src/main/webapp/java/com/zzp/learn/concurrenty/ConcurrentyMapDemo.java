package com.zzp.learn.concurrenty;

/**
 * Desc
 * Created by zzp
 * on 2017/8/9.7:31
 */
public class ConcurrentyMapDemo {

    /**
     * Wang/Jenkins hash
     * @param h
     * @return
     */
    public static int hash(int h) {
        h += (h << 15) ^ 0xffffcd7d;
        System.out.println("first " + h);
        h ^= (h >>> 10);
        System.out.println("second " + h);
        h += (h << 3);
        System.out.println("third " + h);
        h ^= (h >>> 16);
        System.out.println("fourth " + h);
        h += (h << 2) + (h << 14);
        System.out.println("fived " + h);
        return h ^ (h >>> 16);
    }
}
