package com.mrbird.api.demoDesign.design18Strategy.demo2;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }

}
