package com.mrbird.api.demoDesign.design20Factory.factory03;

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

        ComputerFactory3 cf3 = new PVPFactory();
        cf3.playGame().play();
        cf3.playGame2().play();
        ComputerFactory3 cf4 = new PVEFactory();
        cf4.playGame().play();
        cf4.playGame2().play();
    }

}
