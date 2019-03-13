package com.mrbird.api.demoDesign.design19Template.demo1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class CDAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }

}
