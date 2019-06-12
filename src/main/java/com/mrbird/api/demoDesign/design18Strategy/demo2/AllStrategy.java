package com.mrbird.api.demoDesign.design18Strategy.demo2;

/**
 * 抽象折扣类
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public interface AllStrategy {
    /**
     * 计算图书的价格
     *
     * @param booksPrice 图书的原价
     * @return 计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
}
