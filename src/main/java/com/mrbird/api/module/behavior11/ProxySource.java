package com.mrbird.api.module.behavior11;

/**
 * 8.代理模式（Proxy）
 * 客户端通过代理类访问，代理类实现具体的实现细节，客户只需要使用代理类即可实现操作。
 * 这种模式可以对旧功能进行代理，用一个代理类调用原有的方法，且对产生的结果进行控制。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/2/27
 */

interface ProxySource {
    void method();
}

class OldClass implements ProxySource {
    @Override
    public void method() {
    }
}

/**
 * 代理类型
 */
class Proxy implements ProxySource {
    private ProxySource source = new OldClass();

    void doSomething() {
    }

    @Override
    public void method() {
        source.method();
        doSomething();
    }
}
