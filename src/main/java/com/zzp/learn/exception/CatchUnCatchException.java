package com.zzp.learn.exception;

/**
 * Desc 捕获与不捕获异常
 * Created by zzp
 * on 2017/8/9.23:30
 */
public class CatchUnCatchException {

    /**
     * 捕获异常
     */
    public static void catchException() {
        try {
            hasException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after catch exception");
    }

    /**
     * 不捕获异常
     */
    public static void unCatchException() {
        hasException();
        System.out.println("after uncatch exception");
    }

    /**
     * 产生空指针异常
     */
    private static void hasException() {
        String nullStr = null;
        System.out.println(nullStr.equals(""));
    }
}
