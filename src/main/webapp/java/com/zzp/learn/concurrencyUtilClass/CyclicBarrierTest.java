package com.zzp.learn.concurrencyUtilClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Desc 可循环使用的屏障
 *      主要功能：让一组线程到达一个屏障时被阻塞，
 *               直到最后一个线程到达屏障时，屏障才会开门，
 *               所有被屏障拦截的线程才会继续运行
 * Created by zzp
 * on 2017/8/13.19:13
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
