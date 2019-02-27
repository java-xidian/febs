package com.mrbird.api.module.create5;

/**
 * 5. 原型模式（Protype）
 * 原型模式就是讲一个对象作为原型，使用clone()方法来创建新的实例
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/2/27
 */
public class Prototype implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

    public static void main(String[] args) {
        Prototype pro = new Prototype();
        Prototype pro1 = (Prototype) pro.clone();
    }
}