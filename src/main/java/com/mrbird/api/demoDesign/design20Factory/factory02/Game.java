package com.mrbird.api.demoDesign.design20Factory.factory02;

/**
 * 新增处理类
 * <p>
 * 这里还是用上述的玩游戏示例，只不过这里每个游戏都是由各自的游戏工厂类实现。
 * 主要区别就是由一个 工厂类变成了多个了，降低了耦合度。
 * 如果新增一个游戏类，相应的也只需在新增一个工厂类而已， 并且完美的遵循了开放-封闭原则。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public interface Game {
    void play();
}


class LOL implements Game {
    @Override
    public void play() {
        System.out.println("正在玩LOL...");
    }
}

class DNF implements Game {
    @Override
    public void play() {
        System.out.println("正在玩DNF...");
    }
}

class WOW implements Game {
    @Override
    public void play() {
        System.out.println("正在玩WOW...");
    }
}

