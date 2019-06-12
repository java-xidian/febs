package com.mrbird.api.demoDesign.design19Template.demo1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class ClientMain {

    public static void main(String[] args) {
        AllAccount account = new _02MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
        account = new _01CDAccount();
        System.out.println("定期账号的利息数额为：" + account.calculateInterest());
    }

}
