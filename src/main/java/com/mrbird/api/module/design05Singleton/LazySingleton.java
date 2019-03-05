package com.mrbird.api.module.design05Singleton;

/**
 * 上面的懒汉式单例类实现里对静态工厂方法使用了同步化，以处理多线程环境。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    /**
     * 私有默认构造子
     */
    private LazySingleton() {
    }

    /**
     * 静态工厂方法
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
