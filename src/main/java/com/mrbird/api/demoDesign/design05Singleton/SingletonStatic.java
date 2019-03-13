package com.mrbird.api.demoDesign.design05Singleton;

/**
 * 1.要想很简单地实现线程安全，可以采用静态初始化器的方式，它可以由JVM来保证线程的安全性。
 * 比如前面的饿汉式实现方式。但是这样一来，不是会浪费一定的空间吗？
 * 因为这种实现方式，会在类装载的时候就初始化对象，不管你需不需要。
 * 2.如果现在有一种方法能够让类装载的时候不去初始化对象，那不就解决问题了？
 * 一种可行的方式就是采用类级内部类，在这个类级内部类里面去创建对象实例。
 * 这样一来，只要不使用到这个类级内部类，那就不会创建对象实例，从而同时实现延迟加载和线程安全。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class SingletonStatic {
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static SingletonStatic instance = new SingletonStatic();
    }

    public static SingletonStatic getInstance() {
        return SingletonHolder.instance;
    }
}
