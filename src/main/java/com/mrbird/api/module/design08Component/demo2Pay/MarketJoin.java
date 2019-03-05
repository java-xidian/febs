package com.mrbird.api.module.design08Component.demo2Pay;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
// 加盟店 下面不在有分店和加盟店，最底层

public class MarketJoin extends Market {
    public MarketJoin(String s) {
        this.name = s;
    }


    @Override
    public void add(Market m) {
        // TODO Auto-generated method stub
    }


    @Override
    public void remove(Market m) {
        // TODO Auto-generated method stub
    }


    @Override
    public void PayByCard() {
        // TODO Auto-generated method stub
        System.out.println(name + "消费,积分已累加入该会员卡");

    }

}

