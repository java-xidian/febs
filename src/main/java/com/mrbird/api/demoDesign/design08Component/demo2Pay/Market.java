package com.mrbird.api.demoDesign.design08Component.demo2Pay;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public abstract class Market {
    String name;

    public abstract void add(Market m);

    public abstract void remove(Market m);

    public abstract void PayByCard();

}