package com.zzp.learn.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Desc 测试公平锁与非公平锁
 * Created by zzp
 * on 2017/8/8.7:50
 */
public class FairAndUnFairTest {
    private static Lock fairLock = new FairAndUnfair.ReentrantLock2(Boolean.TRUE);
    private static Lock unFairLock = new FairAndUnfair.ReentrantLock2(Boolean.FALSE);
    FairAndUnfair fairAndUnfair = new FairAndUnfair();

    @Test
    public void testFair() {
        fairAndUnfair.testLock(fairLock);
    }
}
