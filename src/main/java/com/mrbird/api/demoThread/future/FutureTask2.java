package com.mrbird.api.demoThread.future;

import java.util.concurrent.*;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/8
 */
public class FutureTask2 {

    public static void main(String[] args) {
        //第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        Task2 task21 = new Task2();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task21);
        executor.submit(futureTask);
        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，
        // 只不过一个使用的是ExecutorService，
        // 一个使用的是Thread
//        Task2 task22 = new Task2();
//        FutureTask<Integer> futureTask22 = new FutureTask<Integer>(task22);
//        Thread thread = new Thread(futureTask22);
//        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }

    static class Task2 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            int count = 100;
            for (int i = 0; i < count; i++) {
                sum += i;
            }
            return sum;
        }
    }
}



