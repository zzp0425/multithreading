package com.zzp.learn.concurrencyUtilClass;

import java.util.concurrent.CountDownLatch;

/**
 * Desc CountDownLatch可以实现join的功能，并且比join的功能更多
 * Created by zzp
 * on 2017/8/11.7:08
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) {
        new Thread(() -> {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);
                countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
            System.out.println(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
