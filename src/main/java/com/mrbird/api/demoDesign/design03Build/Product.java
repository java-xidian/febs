package com.mrbird.api.demoDesign.design03Build;

/**
 * 　导演者角色是与客户端打交道的角色。导演者将客户端创建产品的请求划分为对各个零件的建造请求，
 * 再将这些请求委派给具体建造者角色。具体建造者角色是做具体建造工作的，但是却不为客户端所知。
 * 　　一般来说，每有一个产品类，就有一个相应的具体建造者类。
 * 这些产品应当有一样数目的零件，而每有一个零件就相应地在所有的建造者角色里有一个建造方法。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Product {
    /**
     * 定义一些关于产品的操作
     */
    private String part1;
    private String part2;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }
}
