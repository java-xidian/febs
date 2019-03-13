package com.mrbird.api.demoDesign.design10Decorator.demo1;

/**
 * 　　具体装饰角色
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        // 写相关的业务代码
    }
}
