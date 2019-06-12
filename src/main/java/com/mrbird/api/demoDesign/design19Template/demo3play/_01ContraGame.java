package com.mrbird.api.demoDesign.design19Template.demo3play;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class _01ContraGame extends Game {

    @Override
    protected void runGame() {
        System.out.println("启动魂斗罗II...");
    }

    @Override
    protected void startPlayGame() {
        System.out.println("1P正在使用S弹打aircraft...");
    }

    @Override
    protected void endPlayGame() {
        System.out.println("1P被流弹打死了，游戏结束！");
    }
}