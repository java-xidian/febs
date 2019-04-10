package com.mrbird.api.demoThread.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试阻塞队列的使用（模拟有200个文件需要处理，
 * 由一个读线程去将文件加载到容量为100的阻塞队列，
 * 由四个写线程去进行文件处理）
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/10
 */
public class BlockingQueueTest {
    // 能容纳100个文件
    static final BlockingQueue<String> queue = new LinkedBlockingDeque<>(100);
    //读个数
    static final AtomicInteger RC = new AtomicInteger();
    //写个数
    static final AtomicInteger WC = new AtomicInteger();

    static long randomTime() {
        return (long) (Math.random() * 1000);
    }

    private static void scanFile(String name) {
        try {
            for (int i = 0; i < 200; i++) {
                queue.put("file" + i);
            }
            //放置结束标置
            queue.put("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        while (true) {
            try {
                Thread.sleep(randomTime());
                int index = WC.incrementAndGet();
                String name = queue.take();
                System.out.println(Thread.currentThread() + "=》" + name + "写操作完成，已完成：" + index);
                //队列已经无对象
                if ("".equals(name)) {
                    // 再次添加”标志”，以让其他线程正常退出
                    queue.put("");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //线程池
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Runnable read = new Runnable() {
            @Override
            public void run() {
                scanFile("noNeed");
            }
        };
        Runnable write = new Runnable() {
            @Override
            public void run() {
                writeFile();
            }
        };
        //从线程池起一个读线程
        exec.submit(read);


        //从线程池起四个写线程
        for (int i = 0; i < 4; i++) {
            exec.submit(write);
        }
        exec.shutdown();
    }

}
