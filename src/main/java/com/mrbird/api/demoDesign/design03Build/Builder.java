package com.mrbird.api.demoDesign.design03Build;

/**
 * 抽象建造者类Builder
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public interface Builder {

    public void buildPart1();

    public void buildPart2();

    public Product retrieveResult();
}
