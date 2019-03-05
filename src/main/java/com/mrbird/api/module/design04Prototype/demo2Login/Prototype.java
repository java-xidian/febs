package com.mrbird.api.module.design04Prototype.demo2Login;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public interface Prototype {
    public Prototype clone();

    public String getName();

    public void setName(String name);
}