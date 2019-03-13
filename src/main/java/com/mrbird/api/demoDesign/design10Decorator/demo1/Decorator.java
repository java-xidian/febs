package com.mrbird.api.demoDesign.design10Decorator.demo1;

/**
 * 装饰角色
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        // 委派给构件
        component.sampleOperation();
    }

}
