package com.mrbird.api.module.design06Adapte.demo1Class;

/**
 * 　　在上图中可以看出，Adaptee类并没有sampleOperation2()方法，而客户端则期待这个方法。为使客户端能够使用Adaptee类，提供一个中间环节，即类Adapter，把Adaptee的API与Target类的API衔接起来。Adapter与Adaptee是继承关系，这决定了这个适配器模式是类的：
 * 　　模式所涉及的角色有：
 * 　　●　　目标(Target)角色：这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 * 　　●　　源(Adapee)角色：现在需要适配的接口。
 * 　　●　　适配器(Adaper)角色：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法(有)
     */
    public void sampleOperation1();

    /**
     * 这是源类Adapteee没有的方法(没有)
     */
    public void sampleOperation2();
}
