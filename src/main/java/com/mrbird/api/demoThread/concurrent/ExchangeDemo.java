package com.mrbird.api.demoThread.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 我们在看香港的警匪片的时候，经常会有这种画面，毒贩和贩毒的人，会先约定某个地点，
 * 然后进行一手交钱一手交白粉的勾当，其实这种场景使用jdk1.5并发包中的Exchanger类也可以实现，下面我们就用一个简单的示例，来模拟下这种场景，示例代码如下
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/9
 */
public class ExchangeDemo {

    public static void main(String[] args) {

        // 新建一个Exchanger
        final Exchanger<String> exchanger = new Exchanger<String>();
        // 新建一个线程，该线程持有资源为白粉
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "我有白粉，准备交换钱……");
                    Thread.sleep(5000);
                    /*

                     *  在此处等待另外一个线程到来，并进行数据交换，如果没有另一个线程到来，那么当前这个线程会处于休眠状态，直到3件事情发生：
                     *  1、等待另一个线程到达交换点
                     *  2、被另一个线程中断(警察赶来了，打断了交易)
                     *  3、等待超时，当调用exchanger.exchange(x, timeout, unit)方法时有效(毒贩查觉到危险，没有来交易)
                     */
                    String result = exchanger.exchange("白粉");
                    System.out.println(Thread.currentThread().getName() + "换回来的为:" + " " + result + " 原来为白粉！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
        // 新建一个线程，该线程持有资源为钱
        ExecutorService service2 = Executors.newFixedThreadPool(1);
        service2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "我有钱，准备交换白粉");
                    Thread.sleep(2000);
                    String result = exchanger.exchange("钱");
                    System.out.println(Thread.currentThread().getName() + "换回来的为:" + " " + result + " 原来为钱！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 释放线程资源
        service.shutdown();
        service2.shutdown();
    }

}
