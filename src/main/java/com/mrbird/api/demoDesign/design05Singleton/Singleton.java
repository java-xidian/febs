package com.mrbird.api.demoDesign.design05Singleton;

/**
 * 可以使用“双重检查加锁”的方式来实现，就可以既实现线程安全，又能够使性能不受很大的影响。那么什么是“双重检查加锁”机制呢？
 * 　　所谓“双重检查加锁”机制，指的是：并不是每次进入getInstance方法都需要同步，而是先不同步，
 * 1.进入方法后，先检查实例是否存在，如果不存在才进行下面的同步块，这是第一重检查，
 * 2.进入同步块过后，再次检查实例是否存在，如果不存在，就在同步的情况下创建一个实例，这是第二重检查。
 * 这样一来，就只需要同步一次了，从而减少了多次在同步情况下进行判断所浪费的时间。
 * 　　“双重检查加锁”机制的实现会使用关键字volatile，
 * 它的意思是：被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (Singleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}