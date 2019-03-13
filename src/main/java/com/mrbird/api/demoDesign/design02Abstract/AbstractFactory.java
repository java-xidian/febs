package com.mrbird.api.demoDesign.design02Abstract;

import com.mrbird.api.demoDesign.design01SimpleAmd.Cpu;
import com.mrbird.api.demoDesign.design01SimpleAmd.Mainboard;

/**
 * 1.前面示例实现的CPU接口和CPU实现对象，主板接口和主板实现对象，都不需要变化。
 * 2.前面示例中创建CPU的简单工厂和创建主板的简单工厂，都不再需要。
 * 3.新加入的抽象工厂类和实现类：
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */


public interface AbstractFactory {
    /**
     * 创建CPU对象
     *
     * @return CPU对象
     */
    public Cpu createCpu();

    /**
     * 创建主板对象
     *
     * @return 主板对象
     */
    public Mainboard createMainboard();

}
