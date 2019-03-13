package com.mrbird.api.demoDesign.design16Observable.demo3Java;


import java.util.Observable;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/13
 */
public class Watched extends Observable {

    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {

        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }


}
