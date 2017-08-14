package com.zzp.learn.ececutor;

import java.util.concurrent.*;

/**
 * Desc
 * Created by zzp
 * on 2017/8/14.22:51
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<Long> taks = threadPool.submit(new ReturnFutureTask());
        try {
            Long sum = taks.get();
            System.out.println(sum);
            threadPool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class ReturnFutureTask implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            long sum = 0L;
            for (int i = 0; i < 1000000000; i++) {
                sum += i;
                System.out.println(i);
            }
            return sum;
        }
    }
}
