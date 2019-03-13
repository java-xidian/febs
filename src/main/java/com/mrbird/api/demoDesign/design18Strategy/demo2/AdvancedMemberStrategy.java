package com.mrbird.api.demoDesign.design18Strategy.demo2;

/**
 * 高级会员折扣类
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
