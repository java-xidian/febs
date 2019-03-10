package com.mrbird.api.module.design12Proxy;

/**
 * 代理对象角色
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/6
 */
public class ProxyObject extends AbstractObject {
    RealObject realObject = new RealObject();

    @Override
    public void operation() {
        //调用目标对象之前可以做相关操作
        System.out.println("收钱");
        realObject.operation();
        //调用目标对象之后可以做相关操作
        System.out.println("发货");
    }
}