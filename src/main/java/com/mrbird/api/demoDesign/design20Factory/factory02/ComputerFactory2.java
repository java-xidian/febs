package com.mrbird.api.demoDesign.design20Factory.factory02;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public interface ComputerFactory2 {
    Game playGame();
}

class LOLFactory implements ComputerFactory2 {
    @Override
    public Game playGame() {
        return new LOL();
    }
}

class DNFFactory implements ComputerFactory2 {
    @Override
    public Game playGame() {
        return new DNF();
    }
}

class WOWFactory implements ComputerFactory2 {
    @Override
    public Game playGame() {
        return new WOW();
    }
}
