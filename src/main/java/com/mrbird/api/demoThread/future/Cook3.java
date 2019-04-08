package com.mrbird.api.demoThread.future;

/**
 * 先上一个场景：假如你突然想做饭，但是没有厨具，也没有食材。]
 * 网上购买厨具比较方便，食材去超市买更放心。
 * 实现分析：在快递员送厨具的期间，我们肯定不会闲着，可以去超市买食材。
 * 所以，在主线程里面另起一个子线程去网购厨具。
 * 但是，子线程执行的结果是要返回厨具的，而run方法是没有返回值的。所以，这才是难点，需要好好考虑一下。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/8
 */
public class Cook3 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        OnlineShopping thread = new OnlineShopping();
        thread.start();
        // 保证厨具送到
        thread.join();
        // 第二步 去超市购买食材
        // 模拟购买食材时间
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");
        // 第三步 用厨具烹饪食材
        System.out.println("第三步：开始展现厨艺");
        //传递thread.chuju 对象值
        cook(thread.chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 网购厨具线程
     */
    static class OnlineShopping extends Thread {

        private Chuju chuju;

        @Override
        public void run() {
            System.out.println("第一步：下单");
            System.out.println("第一步：等待送货");
            try {
                // 模拟送货时间
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一步：快递送到");
            chuju = new Chuju();
        }

    }

    /**
     * 用厨具烹饪食材
     *
     * @param chuju
     * @param shicai
     */
    static void cook(Chuju chuju, Shicai shicai) {
    }

    // 厨具类
    static class Chuju {
    }

    static class Shicai {
    }
}
