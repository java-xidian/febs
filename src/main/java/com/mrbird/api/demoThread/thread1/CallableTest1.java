package com.mrbird.api.demoThread.thread1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/29
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Callback
 * 回调一般是异步处理的一种技术。
 * 一个回调是被传递到并且执行完该方法。 这种方式只能异步回调，
 * 如果需要同步等待线程处理结果可以使用下面介绍的Futures
 */

public class CallableTest1 {


    public static void doStm(final ICallback callback) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 初始化一个线程
        WorkThread workThread = new WorkThread(callback);
        executorService.execute(workThread);
        //一定要调用这个方法，不然executorService.isTerminated()永远不为true
        executorService.shutdown();

    }


    public static void main(String[] args) {
        // 内部类 等价于 ICallback callbck = new ICallback的实现类();
        // 新手如果对内部类的写法有疑惑可以查看一下编译后的class文件或许能明白
        // 在编译的时候会把内部类编译成一个实现了ICallback的class
//        doStm(new ICallback() {
//            /**
//             * 现在这个方法是doStm结束后调用<br>
//             * 结束之后会主动把处理参数params传递过来
//             */
//            @Override
//            public void callbackByMyself(Map<String, Object> params) {
//                System.out.println("单个线程也已经处理完毕了，返回参数a1=" + params.get("a1"));
//            }
//        });
        doStm((params) -> {
            // 结束之后会主动把处理参数params传递过来
            //执行完子线程处理
            System.out.println("执行完子线程处理,我的任务已经处理完成了，返回参数a1=" + params.get("a1"));
        });
        System.out.println("主线任务已经执行完了:" + Thread.currentThread().getId());

    }

    static class WorkThread implements Runnable {
        private ICallback callback;

        public WorkThread(ICallback callback) {
            this.callback = callback;
        }

        @Override
        public void run() {
            // 这里是业务逻辑处理
            System.out.println("子线任务执行:" + Thread.currentThread().getId());
            // 为了能看出效果 ，让当前线程阻塞5秒
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //后续,处理完业务逻辑
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("a1", "这是我返回的参数字符串...");
            //返回执行完成参数
            callback.callbackByMyself(params);
        }


    }


}
