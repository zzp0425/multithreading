package com.zzp.learn.concurrenty;

import org.junit.Test;

/**
 * Desc
 * Created by zzp
 * on 2017/8/9.7:37
 */
public class ConcurrentyMapDemoTest {

    ConcurrentyMapDemo concurrentyMap = new ConcurrentyMapDemo();
    /**
     * 测试Wang/Jenkins hash
     */
    @Test
    public void testHash() {
        System.out.println(ConcurrentyMapDemo.hash(10));
        System.out.println(ConcurrentyMapDemo.hash(100));
        System.out.println(ConcurrentyMapDemo.hash(1000));
        System.out.println(ConcurrentyMapDemo.hash(10000));
        System.out.println(ConcurrentyMapDemo.hash(100000));
        System.out.println(ConcurrentyMapDemo.hash(22222));
    }
}
