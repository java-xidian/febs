package com.mrbird.api.module.design17State.demo2;

/**
 * 具体状态类——黑名单
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class BlackVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }

}
