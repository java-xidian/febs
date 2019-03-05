package com.mrbird.api.module.design02Abstract;

import com.mrbird.api.module.design01SimpleAmd.Cpu;
import com.mrbird.api.module.design01SimpleAmd.IntelCpu;
import com.mrbird.api.module.design01SimpleAmd.IntelMainboard;
import com.mrbird.api.module.design01SimpleAmd.Mainboard;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class AmdFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(938);
    }

}
