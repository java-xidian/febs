package com.mrbird.api.module.design16Observable.demo3Java;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class Watcher implements Observer {

    public Watcher(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("状态发生改变：" + ((Watched) o).getData());
    }

}