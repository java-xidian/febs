package com.mrbird.api.demoThread.BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者线程创建一个资源（Object对象）并将它存入队列中，如果队列已经满了（最大为20），
 * 它将会等待直到消费者线程从队列中取走资源，所以队列的长度永远不会超过最大值，比如20。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/10
 */
public class Producer implements Runnable {

    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced resource - Queue size now = "
                        + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer INTERRUPTED");
        }
    }

    /**
     * 加载资源
     *
     * @return
     */
    Object getResource() {
        try {
            // simulate time passing during read
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("Producer Read INTERRUPTED");
        }
        return new Object();
    }
}
