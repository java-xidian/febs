package com.mrbird.api.demoDesign.design04Prototype;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class ConcretePrototype2 implements Prototype {
    @Override
    public Prototype clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }
}