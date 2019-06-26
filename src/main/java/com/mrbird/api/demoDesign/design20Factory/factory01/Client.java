package com.mrbird.api.demoDesign.design20Factory.factory01;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class Client {
    private static final String LOL = "LOL";
    private static final String DNF = "DNF";

    public static void main(String[] args) {
        Game game = ComputerFactory.playGame(LOL);
        Game game2 = ComputerFactory.playGame(DNF);
        game.play();
        game2.play();
    }
}
