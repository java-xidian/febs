package com.mrbird.api.demoDesign.design18Strategy;

/**
 * 持有一个具体策略的对象
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class HolderContext {

    private Strategy strategy;

    /**
     * 构造函数，传入一个具体策略对象
     *
     * @param strategy 具体策略对象
     */
    public HolderContext(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextInterface() {

        strategy.strategyInterface();
    }
}
