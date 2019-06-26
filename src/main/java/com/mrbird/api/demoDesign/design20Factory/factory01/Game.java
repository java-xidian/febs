package com.mrbird.api.demoDesign.design20Factory.factory01;

/**
 * 1.打个比方，我们在电脑经常玩游戏，我们只需要告诉电脑我们要玩什么游戏，电脑就会打开这个游戏，我们并不需要关心游戏是怎么运作的。
 * <p>
 * 2我们首先创建一个游戏总类接口，包含一个玩游戏的方法； 然后再由各自的游戏类继承该类并实现该类的方法，最后在创建一个工程类根据不同的游戏进行创建对象。
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
