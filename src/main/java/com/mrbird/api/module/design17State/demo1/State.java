package com.mrbird.api.module.design17State.demo1;

/**
 * 抽象状态类
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */


public interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}