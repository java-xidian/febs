package com.mrbird.api.demoDesign.design20Factory.factory01;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class ComputerFactory {
    private static final String LOL = "LOL";
    private static final String DNF = "DNF";

    public static Game playGame(String game) {
        if (LOL.equalsIgnoreCase(game)) {
            return new LOL();
        } else if (DNF.equalsIgnoreCase(game)) {
            return new DNF();
        }
        return null;
    }
}