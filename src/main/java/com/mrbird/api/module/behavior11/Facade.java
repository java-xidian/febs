package com.mrbird.api.module.behavior11;

/**
 * 9.外观模式（Facade）
 * 为子系统中的一组接口提供一个一致的界面，定义一个高层接口，这个接口使得这一子系统更加容易使用。
 * 这句话是百度百科的解释，有点难懂，但是没事，看下面的例子，
 * 我们在启动停止所有子系统的时候，为它们设计一个外观类，这样就可以实现统一的接口，
 * 这样即使有新增的子系统subSystem4,也可以在不修改客户端代码的情况下轻松完成。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/2/27
 */
public class Facade {
//    private subSystem1 subSystem1 = new subSystem1();
//    private subSystem2 subSystem2 = new subSystem2();
//    private subSystem3 subSystem3 = new subSystem3();
//
//    public void startSystem() {
//        subSystem1.start();
//        subSystem2.start();
//        subSystem3.start();
//    }
//
//    public void stopSystem() {
//        subSystem1.stop();
//        subSystem2.stop();
//        subSystem3.stop();
//    }
}
