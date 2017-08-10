package com.zzp.learn.mode;

import com.zzp.learn.util.SleepUtil;
import org.junit.Test;
import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Desc 测试单例
 * Created by zzp
 * on 2017/8/10.7:39
 */
public class SingletonTest {

    @Test
    public void testSingleton() {
        ExecutorService executors = Executors.newFixedThreadPool(1000);
        List<GetSingleton> calls = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            calls.add(new GetSingleton());
        }
        try {
            List<Future<Singleton>> futures = executors.invokeAll(calls);
            SleepUtil.second(5);
            for (int i = 0; i < 999; i++) {
                Singleton singleton = futures.get(i).get();
                Singleton singleton1 = futures.get(i + 1).get();
                System.out.println(singleton == singleton1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public class GetSingleton implements Callable<Singleton> {

        @Override
        public Singleton call() throws Exception {
            return Singleton.getInstance();
        }
    }
}
