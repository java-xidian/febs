package com.mrbird.api.module.design16Observable.demo1;

/**
 * 　抽象观察者角色类
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/11
 */
public interface Observer {
    /**
     * 更新接口
     *
     * @param state 更新的状态
     */
    public void update(String state);
}
