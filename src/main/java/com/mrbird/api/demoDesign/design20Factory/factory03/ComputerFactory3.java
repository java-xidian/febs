package com.mrbird.api.demoDesign.design20Factory.factory03;

/**
 * 添加系列
 * 在抽象工厂模式中，可以在不需要知道产品是怎么样的，只需知道是哪个工厂类就行了。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public interface ComputerFactory3 {
    Game playGame();

    Game playGame2();
}


class PVPFactory implements ComputerFactory3 {

    @Override
    public Game playGame() {
        return new LOL();
    }

    @Override
    public Game playGame2() {
        return new WOW();
    }
}

class PVEFactory implements ComputerFactory3 {

    @Override
    public Game playGame() {
        return new DNF();
    }

    @Override
    public Game playGame2() {
        return new WOW();
    }

}