package com.zzp.learn.ececutor;

import java.util.concurrent.*;

/**
 * Desc
 * Created by zzp
 * on 2017/8/16.7:13
 */
public class FutureTaskTest2 {
    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private String executionTask(final String taskName) {
        while (true) {
            Future<String> future = taskCache.get(taskName);
            if (future == null) {
                Callable<String> task = () -> (taskName);
                //创建任务
                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FutureTaskTest2 test = new FutureTaskTest2();
        System.out.println(test.executionTask("zzp"));
    }
}
