package com.mrbird.api.module.behavior11;

/**
 * 7.装饰模式（Decorator）
 * 给一类对象增加新的功能，装饰方法与具体的内部逻辑无关。例如：
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/2/27
 */
interface Source {
    void method();
}

class Decorator implements Source {

    private Source source;

    public void decotate1() {
        System.out.println("decorate");
    }

    @Override
    public void method() {
        decotate1();
        source.method();
    }
}