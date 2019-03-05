package com.mrbird.api.module.design08Component;

/**
 * 共同属性
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public abstract class Component {
    String name;

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void eachChild();
}
