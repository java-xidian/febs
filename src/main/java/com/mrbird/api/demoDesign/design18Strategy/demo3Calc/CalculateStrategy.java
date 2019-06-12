package com.mrbird.api.demoDesign.design18Strategy.demo3Calc;

/**
 * 首先定义一个抽象策略角色，并拥有一个计算的方法。
 * 共同入口
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
interface CalculateStrategy {
    int doOperation(int num1, int num2);
}
