package com.mrbird.api.demoDesign.design01SimpleAmd;

/**
 * XXXXXX
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class MainboardFactory {
    public static Mainboard createMainboard(int type) {
        Mainboard mainboard = null;
        if (type == 1) {
            mainboard = new IntelMainboard(755);
        } else if (type == 2) {
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
