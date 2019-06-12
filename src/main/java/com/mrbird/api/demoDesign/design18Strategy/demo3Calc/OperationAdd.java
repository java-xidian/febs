package com.mrbird.api.demoDesign.design18Strategy.demo3Calc;

/**
 * 然后再定义加减乘除这些具体策略角色并实现方法。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
class OperationAdd implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSub implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMul implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class OperationDiv implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}
