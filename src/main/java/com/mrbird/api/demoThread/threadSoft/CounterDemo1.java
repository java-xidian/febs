package com.mrbird.api.demoThread.threadSoft;

import com.google.common.util.concurrent.AtomicLongMap;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/9
 */
public class CounterDemo1 {


    private AtomicLongMap<String> urlCounter3 = AtomicLongMap.create();

    public long increase3(String url) {
        long newValue = urlCounter3.incrementAndGet(url);
        return newValue;
    }

    public Long getCount3(String url) {
        return urlCounter3.get(url);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final CounterDemo1 counterDemo = new CounterDemo1();
        int callTime = 100000;
        final String url = "http://localhost:8080/hello";
        CountDownLatch countDownLatch = new CountDownLatch(callTime);
        //模拟并发情况下的接口调用统计
        for (int i = 0; i < callTime; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    counterDemo.increase3(url);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        //等待所有线程统计完成后输出调用次数
        System.out.println("调用次数：" + counterDemo.getCount3(url));
    }
}
