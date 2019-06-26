package com.mrbird.api.demoDesign.design20Factory.factory03;

/**
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
