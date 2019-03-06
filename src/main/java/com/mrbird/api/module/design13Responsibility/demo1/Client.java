package com.mrbird.api.module.design13Responsibility.demo1;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/6
 */
public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler2 = new ConcreteHandler();
        Handler handler1 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }

}