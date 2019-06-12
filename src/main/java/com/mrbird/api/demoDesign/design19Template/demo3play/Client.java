package com.mrbird.api.demoDesign.design19Template.demo3play;

/**
 * $$$$$$$$$$提取共同方法$$$$$$$$$$
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/6/12
 */
public class Client {
    public static void main(String[] args) {
        Game game = new _01ContraGame();
        game.play();
        System.out.println();
        game = new _02TMNTGame();
        game.play();

    }
}
