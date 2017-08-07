package com.zzp.learn;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Desc
 * Created by zzp
 * on 2017/7/17.22:54
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取Java线程管理Bean
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false, false);

        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + " " + info.getThreadName());
        }
    }
}
