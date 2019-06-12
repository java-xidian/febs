package com.mrbird.api.demoDesign.design18Strategy.demo3Calc;

/**
 * 最后在定义一个环境角色，提供一个计算的接口供客户端使用。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class CalculatorContext {
    private CalculateStrategy strategy;

    public CalculatorContext(CalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
