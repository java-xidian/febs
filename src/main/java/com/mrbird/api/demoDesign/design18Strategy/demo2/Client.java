package com.mrbird.api.demoDesign.design18Strategy.demo2;

/**
 * 从上面的示例可以看出，策略模式仅仅封装算法，提供新的算法插入到已有系统中，
 * 以及老算法从系统中“退休”的方法，策略模式并不决定在何时使用何种算法。在什么情况下使用什么算法是由客户端决定的。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class Client {
    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        AllStrategy strategy = new _03AdvancedMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }
}
