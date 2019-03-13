package com.mrbird.api.module.design17State.demo2;

/**
 * 具体状态类——恶意刷票
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class SpiteVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 恶意投票，取消用户的投票资格，并取消投票记录
        String str = voteManager.getMapVoteResult().get(user);
        if (str != null) {
            voteManager.getMapVoteResult().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
    }

}
