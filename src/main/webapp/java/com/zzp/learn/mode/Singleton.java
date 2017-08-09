package com.zzp.learn.mode;

/**
 * Desc 多线程优化单例
 * Created by zzp
 * on 2017/8/10.7:24
 */
public class Singleton {

    /**
     * 用volatile修饰
     * 初始化经过
     *  1. 分配对象的内存空间
     *  2. 初始化难对象
     *  3. 设置instance指向刚分配的内存地址
     *  2跟3可能会被重排序，导致instance提前不为空
     *  volatile可以解决重排序的问题
     */
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
