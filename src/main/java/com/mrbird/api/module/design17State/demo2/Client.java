package com.mrbird.api.module.design17State.demo2;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class Client {

    public static void main(String[] args) {

        VoteManager vm = new VoteManager();
        for (int i = 0; i < 9; i++) {
            vm.vote("u1", "A");
        }
    }

}
