package com.mrbird.api.module.design12Proxy;

/**
 * 从上面的例子可以看出代理对象将客户端的调用委派给目标对象，
 * 在调用目标对象的方法之前跟之后都可以执行特定的操作。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/6
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }

}
