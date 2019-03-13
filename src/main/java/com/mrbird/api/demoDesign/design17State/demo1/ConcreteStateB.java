package com.mrbird.api.demoDesign.design17State.demo1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {

        System.out.println("ConcreteStateB handle ：" + sampleParameter);
    }

}
