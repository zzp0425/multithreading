package com.zzp.learn.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc 公平锁与非公平锁测试
 * Created by zzp
 * on 2017/8/8.7:07
 */
public class FairAndUnfair {


    public void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock);
            thread.start();
        }
    }

    private static class Job extends Thread {
        private Lock lock;
        public Job(Lock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            System.out.println(11);
            ReentrantLock2 fairUnfair = (ReentrantLock2) this.lock;
            System.out.println("lock by [" + Thread.currentThread().getName() + "]" + fairUnfair.getQueuedThreads());
        }
    }


    public class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
