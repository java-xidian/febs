package com.mrbird.api.demoDesign.design10Decorator.demo2Monkey;

/**
 * 　具体装饰角色“鸟儿”
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class Bird extends Change {

    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // 代码
        System.out.println("Bird Move");
    }
}
