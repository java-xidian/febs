package com.mrbird.api.demoDesign.design18Strategy.demo2;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }

}
