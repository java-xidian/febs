package com.mrbird.api.module.design04Prototype;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Client {

    /**
     * 持有需要使用的原型接口对象
     */
    private Prototype prototype;

    /**
     * 构造方法，传入需要使用的原型接口对象
     */
    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    /**
     * 需要创建原型接口的对象
     *
     * @param example
     */
    public void operation(Prototype example) {
        Prototype copyPrototype = (Prototype) prototype.clone();

    }
}
