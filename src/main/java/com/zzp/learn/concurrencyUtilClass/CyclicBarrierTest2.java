package com.zzp.learn.concurrencyUtilClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Desc
 * Created by zzp
 * on 2017/8/13.19:23
 */
public class CyclicBarrierTest2 {
    /**
     * CyclicBarrier(int parties, Runnable barrierAction)
     * 用于在线程到达屏障时优先执行BarrierAction
     */
    static CyclicBarrier c = new CyclicBarrier(2, BarrierAction::new);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

//        try {
//            c.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
        System.out.println(2);
    }


    static class BarrierAction implements Runnable {

        @Override
        public void run() {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }
    }
}
