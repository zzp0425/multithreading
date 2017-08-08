package com.zzp.learn.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Desc 测试公平锁与非公平锁
 * Created by zzp
 * on 2017/8/8.7:50
 */
public class FairAndUnFairTest {

    static FairAndUnfair fairAndUnfair = new FairAndUnfair();
    private static Lock fairLock = fairAndUnfair.new ReentrantLock2(Boolean.TRUE);
    private static Lock unFairLock = fairAndUnfair.new ReentrantLock2(Boolean.FALSE);

    @Test
    public void testFair() {
        fairAndUnfair.testLock(fairLock);
    }

    @Test
    public void testUnFair() {
        fairAndUnfair.testLock(unFairLock);
    }
}
