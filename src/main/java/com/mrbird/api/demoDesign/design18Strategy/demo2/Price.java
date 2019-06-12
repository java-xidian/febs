package com.mrbird.api.demoDesign.design18Strategy.demo2;

/**
 * 价格类
 * 持有一个具体的策略对象
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class Price {
    private AllStrategy strategy;

    /**
     * 构造函数，传入一个具体的策略对象
     *
     * @param strategy 具体的策略对象
     */
    public Price(AllStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算图书的价格
     *
     * @param booksPrice 图书的原价
     * @return 计算出打折后的价格
     */
    public double quote(double booksPrice) {
        return this.strategy.calcPrice(booksPrice);
    }
}