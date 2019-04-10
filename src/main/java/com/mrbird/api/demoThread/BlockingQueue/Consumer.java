package com.mrbird.api.demoThread.BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/10
 */
class Consumer implements Runnable {
    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = queue.take();
                System.out.println("Consumed resource - Queue size now = "
                        + queue.size());
                take(obj);
            }
        } catch (InterruptedException ex) {
            System.out.println("CONSUMER INTERRUPTED");
        }
    }

    void take(Object obj) {
        try {
            // simulate time passing
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("Consumer Read INTERRUPTED");
        }
        System.out.println("Consuming object " + obj);
    }
}
