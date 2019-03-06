package com.mrbird.api.module.design10Decorator.demo2Monkey;

/**
 * 　具体装饰角色“鱼儿”
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class Fish extends Change {

    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // 代码
        System.out.println("Fish Move");
    }
}
