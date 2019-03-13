package com.mrbird.api.demoDesign.design10Decorator.demo2Monkey;

/**
 * 抽象装饰角色“七十二变”
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class Change implements TheGreatestSage {
    private TheGreatestSage sage;

    public Change(TheGreatestSage sage) {
        this.sage = sage;
    }

    @Override
    public void move() {
        // 代码
        sage.move();
    }

}
