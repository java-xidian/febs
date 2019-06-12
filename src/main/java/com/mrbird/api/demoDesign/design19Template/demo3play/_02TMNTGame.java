package com.mrbird.api.demoDesign.design19Template.demo3play;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class _02TMNTGame extends Game {

    @Override
    protected void runGame() {
        System.out.println("启动忍者神龟III...");
    }

    @Override
    protected void choosePerson() {
        System.out.println("1P选择了Raph ！");
    }

    @Override
    protected void startPlayGame() {
        System.out.println("Raph正在使用绝技 “火箭头槌” ");
    }

    @Override
    protected void endPlayGame() {
        System.out.println("Raph 掉进井盖里死了，游戏结束了！ ");
    }
}
