package com.mrbird.api.module.design06Adapte.demo3Class;

/**
 * 鲁智深走后门进去的
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/5
 */
public class 鲁智深 extends 天星 {
    @Override
    public void 习武() {
        System.out.println("拳打镇关西;\n" +
                "        大闹五台山;\n" +
                "        大闹桃花村;\n" +
                "        火烧瓦官寺;\n" +
                "        倒拔垂杨柳;");
    }

    @Override
    public String getName() {
        return "鲁智深";
    }
}