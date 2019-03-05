package com.mrbird.api.module.design05Singleton;

/**
 * 单元素的枚举类型已经成为实现Singleton的最佳方法。用枚举来实现单例非常简单，
 * 只需要编写一个包含单个元素的枚举类型即可。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public enum SingletonEnum {
    /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
     */

    uniqueinstance;

    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation() {
        //功能处理
    }
}
