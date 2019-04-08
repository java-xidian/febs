package com.mrbird.api.demoThread.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池中方法计时
 * 线程池中提供了监控线程池运行的一些方法，
 * 这里通过线程池的 isTerminated() 方法不断检测，
 * 线程池中的任务是否都执行完成了，来获取所有任务结束时间。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/29
 */
public class ExecuteOrderPractice {

    public void orderPractice() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " do something");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                //System.out.println("Finally do something ");
                long end = System.currentTimeMillis();
                System.out.println("用时: " + (end - start) + "ms");
                break;
            }

        }
    }

    public static void main(String[] args) {
        new ExecuteOrderPractice().orderPractice();

    }
}

