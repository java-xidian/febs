package com.mrbird.api.demoDesign.design19Template.demo3play;

/**
 * 定义流程
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public abstract class Game {

    //启动游戏
    protected abstract void runGame();

    //选择人物
    protected void choosePerson() {
    }

    ;

    //开始玩游戏
    protected abstract void startPlayGame();

    //结束游戏
    protected abstract void endPlayGame();

    //模板方法
    public final void play() {
        runGame();
        choosePerson();
        startPlayGame();
        endPlayGame();
    }

}
