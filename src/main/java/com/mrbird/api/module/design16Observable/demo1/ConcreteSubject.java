package com.mrbird.api.module.design16Observable.demo1;

/**
 * 　具体主题角色类
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/11
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    /**
     * 内容改变通知观察者
     *
     * @param newState
     */
    public void change(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}
