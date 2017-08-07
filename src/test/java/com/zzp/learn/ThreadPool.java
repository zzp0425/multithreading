package com.zzp.learn;

/**
 * Desc
 * Created by zzp
 * on 2017/7/19.22:56
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorkers(int num);
    void removeWorker(int num);
    int getJobSize();
}
