package com.zzp.learn;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * Desc 测试join
 * Created by zzp
 * on 2017/7/19.6:48
 */
public class Join {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        System.out.println(Thread.currentThread().getName() + " terminate");
    }

    public static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(Thread.currentThread().getName() + " terminate");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
