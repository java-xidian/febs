package com.mrbird.api.module.create5;

/**
 * 1. 工厂模式（Factory Method）
 * 　　常用的工厂模式是静态工厂，利用static方法，作为一种类似于常见的工具类Utils等辅助效果，
 * 一般情况下工厂类不需要实例化
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/2/27
 */
interface food {
}

class A implements food {
}

class B implements food {
}

class C implements food {
}

/**
 * 一般情况下工厂类不需要实例化
 */
class StaticFactory {

    private StaticFactory() {
    }

    public static food getA() {
        return new A();
    }

    public static food getB() {
        return new B();
    }

    public static food getC() {
        return new C();
    }
}

class Client {
    //客户端代码只需要将相应的参数传入即可得到对象,用户不需要了解工厂类内部的逻辑。

    public void get(String name) {
        food x = null;
        if (name.equals("A")) {
            x = StaticFactory.getA();
        } else if (name.equals("B")) {
            x = StaticFactory.getB();
        } else {
            x = StaticFactory.getC();
        }
    }
}