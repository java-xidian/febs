package com.mrbird.api.demoDesign.design09Facade.demo1hospital;

/**
 * 示意方法，满足客户端需要的功能
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */

public class Facade {
    public void test() {
        ModuleA a = new ModuleA();
        a.testA();
        ModuleB b = new ModuleB();
        b.testB();
        ModuleC c = new ModuleC();
        c.testC();
    }

}

