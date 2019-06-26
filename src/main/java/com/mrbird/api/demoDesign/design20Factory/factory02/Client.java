package com.mrbird.api.demoDesign.design20Factory.factory02;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class Client {
    private static final String LOL = "LOL";
    private static final String DNF = "DNF";
    private static final String WOW = "WOW";

    public static void main(String[] args) {

        Game game3 = new LOLFactory().playGame();
        Game game4 = new DNFFactory().playGame();
        Game game5 = new WOWFactory().playGame();
        game3.play();
        game4.play();
        game5.play();
    }
}
