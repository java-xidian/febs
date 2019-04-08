package com.mrbird.api.demoThread.thread1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/29
 */

import java.util.concurrent.*;

/**
 * Future
 * Futures是一个抽象的概念，它表示一个值，该值可能在某一点变得可用。一个Future要么获得
 * 计算完的结果，要么获得计算失败后的异常。
 * Java在java.util.concurrent包中附带了Future接口，它使用Executor异步执行。例
 * 如下面的代码，每传递一个Runnable对象到ExecutorService.submit()方法就会得到一个回调的Future，
 * 你能使用它检测是否执行，这种方法可以是同步等待线处理结果
 * 完成。
 */

public class CallableTest4 {


    /**
     * FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //实现一个Callable接口
        ThreadDemo threadDemo = new ThreadDemo();
        FutureTask<Netty> futureTask = new FutureTask<Netty>(threadDemo);
        executorService.submit(futureTask);
        executorService.shutdown();
        try {
            //处理完毕后返回的结果
            Netty netty = futureTask.get();
            System.out.println("线程执行完成123" + netty.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class ThreadDemo implements Callable<Netty> {
        @Override
        public Netty call() throws Exception {
            //这里是你的业务逻辑处理
            //让当前线程阻塞1秒看下效果
            Thread.sleep(5000);
            return new Netty("张三");
        }
    }

    static class Netty {
        private String name;

        private Netty(String name) {
            this.name = name;
        }
    }

}

