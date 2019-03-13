package com.mrbird.api.demoDesign.design17State.demo2;

/**
 * 具体状态类——正常投票
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class NormalVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //正常投票，记录到投票记录中
        voteManager.getMapVoteResult().put(user, voteItem);
        System.out.println("恭喜投票成功");
    }

}