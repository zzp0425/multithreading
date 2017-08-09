package com.zzp.learn.exception;

import org.junit.Test;

/**
 * Desc 捕获与不捕获异常测试
 * Created by zzp
 * on 2017/8/9.23:34
 */
public class CatchUnCatchExceptionTest {

    /**
     * 测试捕获异常
     */
    @Test
    public void testCatchException() {
        CatchUnCatchException.catchException();
    }

    /**
     * 测试不捕获异常
     */
    @Test
    public void testUnCatchException() {
        CatchUnCatchException.unCatchException();;
    }
}
