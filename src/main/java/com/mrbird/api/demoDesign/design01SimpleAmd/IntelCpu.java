package com.mrbird.api.demoDesign.design01SimpleAmd;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class IntelCpu implements Cpu {
    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("Intel CPU的针脚数：" + pins);
    }
}
