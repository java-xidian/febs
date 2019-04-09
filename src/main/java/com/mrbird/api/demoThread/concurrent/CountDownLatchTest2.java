package com.mrbird.api.demoThread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、CountDownLatch：一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 * 2、ThreadPoolExecutor/ExecutorService：线程池，使用线程池可以复用线程，降低频繁创建线程造成的性能消耗，
 * 同时对线程的创建、启动、停止、销毁等操作更简便。
 * 3、使用场景举例：
 * 年末公司组织团建，要求每一位员工周六上午8点到公司门口集合，统一乘坐公司所租大巴前往目的地。
 * 在这个案例中，公司作为主线程，员工作为子线程。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/9
 */
public class CountDownLatchTest2 {

    public static void main(String[] args) throws InterruptedException {

        //员工数量
        int count = 5;
        //创建计数器
        //构造参数传入的数量值代表的是latch.countDown()调用的次数
        CountDownLatch latch = new CountDownLatch(count);

        //创建线程池，可以通过以下方式创建
        //ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,1,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(count));
        ExecutorService threadPool = Executors.newFixedThreadPool(count);

        System.out.println("公司发送通知，每一位员工在周六早上8点到公司大门口集合");
        for (int i = 0; i < count; i++) {
            //将子线程添加进线程池执行
            Thread.sleep(10);
            threadPool.execute(new Employee(latch, i + 1));
        }
        try {
            //阻塞当前线程，直到所有员工到达公司大门口之后才执行
            latch.await();
            // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
            //latch.await(long timeout, TimeUnit unit)
            System.out.println("所有员工已经到达公司大门口，大巴车发动，前往活动目的地。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //最后关闭线程池，但执行以前提交的任务，不接受新任务
            threadPool.shutdown();
            //关闭线程池，停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
            //threadPool.shutdownNow();
        }
    }

    //分布式工作线程
    static class Employee implements Runnable {

        private CountDownLatch latch;
        private int employeeIndex;

        public Employee(CountDownLatch latch, int employeeIndex) {
            this.latch = latch;
            this.employeeIndex = employeeIndex;
        }

        @Override
        public void run() {
            try {
                System.out.println("员工：" + employeeIndex + "，正在前往公司大门口集合...");
                Thread.sleep(10);
                System.out.println("员工：" + employeeIndex + "，已到达。");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //当前计算工作已结束，计数器减一
                latch.countDown();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //执行coutDown()之后，继续执行自己的工作，不受主线程的影响
                System.out.println("员工：" + employeeIndex + "，吃饭、喝水、拍照。");
            }
        }
    }
}


