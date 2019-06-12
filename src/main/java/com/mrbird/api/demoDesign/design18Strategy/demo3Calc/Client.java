package com.mrbird.api.demoDesign.design18Strategy.demo3Calc;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class Client {
    public static void main(String[] args) {
        int a = 4, b = 2;
        CalculatorContext context = new CalculatorContext(new OperationAdd());
        System.out.println("a + b = " + context.executeStrategy(a, b));

        CalculatorContext context2 = new CalculatorContext(new OperationSub());
        System.out.println("a - b = " + context2.executeStrategy(a, b));

        CalculatorContext context3 = new CalculatorContext(new OperationMul());
        System.out.println("a * b = " + context3.executeStrategy(a, b));

        CalculatorContext context4 = new CalculatorContext(new OperationDiv());
        System.out.println("a / b = " + context4.executeStrategy(a, b));
    }
}
