package com.mrbird.api.module.design17State.demo1;

/**
 * 从上面可以看出，环境类Context的行为request()是委派给某一个具体状态类的。
 * 通过使用多态性原则，可以动态改变环境类Context的属性State的内容，使其从指向一个具体状态类变换到指向另一个具体状态类，
 * 从而使环境类的行为request()由不同的具体状态类来执行
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class Client {

    public static void main(String[] args) {
        //创建环境
        Context context = new Context();
        //创建状态
        State state = new ConcreteStateB();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("test");
    }
}
