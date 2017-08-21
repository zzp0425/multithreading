package com.zzp.learn.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Desc 整型数组原子操作
 * Created by zzp
 * on 2017/8/11.6:45
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[] {1, 2};
    static AtomicIntegerArray aia = new AtomicIntegerArray(value);

    /**
     * 输出结果
     *  3
     *  1
     * 原因：AtomicIntegerArray会将当前数组复制一份，
     *  所以当AtomicIntegerArray对内部的数组元素进行修改时，
     *  不会影响传入的数组
     * @param args
     */
    public static void main(String[] args) {
        aia.getAndSet(0, 3);
        System.out.println(aia.get(0));
        System.out.println(value[0]);
    }
}
