package com.mrbird.api.demoThread.thread2;

/**
 * 使用 CountDownLatch 计时
 * <p>
 * 思路：用两个 CountDownLatch 倒计时锁：开始计时锁，任务结束计时锁。
 * 开始计时锁在子线程任务开始时通过 await() 阻塞所有子线程，
 * 然后在主线程中通过 CountDownLatch 控制所有子线程同时开始获取开始时间；
 * 任务结束计时锁 CountDownLatch 在每个子线程执行完后都 countDown 一次，直到所有子线程执行完，
 * 主线程开始记录所有任务执行结束时间。
 * <p>
 * * ClassName: ThreadTiming <br/>
 * * Function: 计算多个线程任务执行完后的用时<br/>
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/29
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadTiming {

    private int nThread;

    private CountDownLatch startGate;
    private CountDownLatch endGate;

    public ThreadTiming(int nThread, CountDownLatch startGate, CountDownLatch endGate) {

        this.nThread = nThread;
        this.startGate = startGate;
        this.endGate = endGate;
    }

    class worker implements Runnable {

        @Override
        public void run() {
            try {
                startGate.await();
                Random random = new Random();
                int num = random.nextInt(500) + 500;
                System.out.println(Thread.currentThread().getName() + " start and sleep: " + num + "ms");
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
            }
        }
    }

    public long timeTasks() {

        for (int i = 0; i < nThread; i++) {
            Thread thread = new Thread(new worker());
            thread.start();
        }

        long start = System.currentTimeMillis();
        //所有阻塞的任务同时开始
        startGate.countDown();
        try {
            //主线程阻塞,等待其他所有 worker 线程完成后再执行
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时: " + (end - start) + "ms");

        return end - start;
    }

    public static void main(String[] args) {

        int nThread = 5;
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThread);

        new ThreadTiming(nThread, startGate, endGate).timeTasks();

    }
}

