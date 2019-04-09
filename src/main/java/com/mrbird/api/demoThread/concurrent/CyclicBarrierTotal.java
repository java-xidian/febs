package com.mrbird.api.demoThread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 应用场景
 * 在某种需求中，比如一个大型的任务，常常需要分配好多子任务去执行，只有当所有子任务都执行完成时候，才能执行主任务，
 * 这时候，就可以选择CyclicBarrier了。 实例分析
 * 我们需要统计全国的业务数据。其中各省的数据库是独立的，也就是说按省分库。
 * 并且统计的数据量很大，统计过程也比较慢。
 * 为了提高性能，快速计算。我们采取并发的方式，多个线程同时计算各省数据，最后再汇总统计。
 * 在这里CyclicBarrier就非常有用。
 * <p>
 * <p>
 * 各省数据独立，分库存偖。为了提高计算性能，统计时采用每个省开一个线程先计算单省结果，最后汇总。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/9
 */
public class CyclicBarrierTotal {

    /**
     * 1.询价结果
     */
    static class Result {

        private String site;

        private int price;

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        int getPrice() {
            return price;
        }

        void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "site='" + site + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    /**
     * 2.询价接口
     */
    static class AskTask implements Runnable {

        private CyclicBarrier barrier;

        private final List<Result> results;

        AskTask(CyclicBarrier barrier, List<Result> results) {
            this.barrier = barrier;
            this.results = results;
        }

        @Override
        public void run() {
            Result result = null;
            try {
                // 模拟网络耗时获取数据
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 3000));
                result = new Result();
                result.setPrice((new Random().nextInt(1000) + 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (results) {
                if (result != null) {
                    /* 模拟报价站点名称 */
                    String[] sites = {"苏宁", "天猫", "京东"};
                    result.setSite(sites[results.size()]);
                    // 添加到共享变量list中
                    results.add(result);
                }
            }
            try {
                System.out.println("询价结束，等待其它线程..." + result);
                // 抵达屏障
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        final List<Result> results = new ArrayList<>();
        CyclicBarrier barrier = new CyclicBarrier(3,
                new Runnable() {
                    @Override
                    public void run() {
                        if (!results.isEmpty()) {
                            Result min = results.get(0);
                            for (Result result : results) {
                                if (result.getPrice() < min.getPrice()) {
                                    min = result;
                                }
                                ;
                            }
                            System.out.println("最低报价是：" + min);
                        }
                    }
                });
        // 模拟三个询价接口，采用线程池管理
        for (int i = 0; i < 3; i++) {
            AskTask c = new AskTask(barrier, results);
            service.submit(c);
        }
        service.shutdown();
    }


}


