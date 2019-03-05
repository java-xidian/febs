package com.mrbird.api.module.design04Prototype.demo2Login;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class ConcretePrototype1 implements Prototype {
    private String name;

    @Override
    public Prototype clone() {
        ConcretePrototype1 prototype = new ConcretePrototype1();
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String toString() {
        return "Now in Prototype1 , name = " + this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}