package com.zzp.learn.concurrencyUtilClass;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc 线程间交换数据的Exchanger
 * Created by zzp
 * on 2017/8/13.20:22
 */
public class ExchangerTest {

    public static final Exchanger<String> exgr = new Exchanger<>();
    public static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String A = "银行流水A";
                exgr.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                String B = "银行流水B";
                String A = exgr.exchange(B);
                System.out.println("A和B数据是否一致：" + A.equals(B) + "\r\nA录入的是:" + A  + "\r\nB录入的是:" + B );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
