package com.mrbird.api.demoDesign.design19Template;

/**
 * 具体模板角色类，实现了父类所声明的基本方法，
 * abstractMethod()方法所代表的就是强制子类实现的剩余逻辑，
 * 而hookMethod()方法是可选择实现的逻辑，不是必须实现的。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class ConcreteTemplate extends AbstractTemplate {
    //强制子类实现的剩余逻辑 基本方法的实现
    @Override
    public void abstractMethod() {
        //业务相关的代码
    }

    //重写父类的方法
    @Override
    public void hookMethod() {
        //业务相关的代码
    }
}
