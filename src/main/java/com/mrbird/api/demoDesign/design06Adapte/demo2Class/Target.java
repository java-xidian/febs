package com.mrbird.api.demoDesign.design06Adapte.demo2Class;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1();

    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2();
}
