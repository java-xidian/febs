package com.mrbird.api.demoDesign.design04Prototype;

/**
 * 　　具体原型角色
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class ConcretePrototype1 implements Prototype {

    @Override
    public Prototype clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype1();
        return prototype;
    }
}