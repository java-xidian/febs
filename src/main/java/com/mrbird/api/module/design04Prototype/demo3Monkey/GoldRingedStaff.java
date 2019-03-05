package com.mrbird.api.module.design04Prototype.demo3Monkey;

/**
 * 大圣还持有一个金箍棒的实例，金箍棒类GoldRingedStaff:
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class GoldRingedStaff {
    private float height = 100.0f;
    private float diameter = 10.0f;

    /**
     * 增长行为，每次调用长度和半径增加一倍
     */
    public void grow() {
        this.diameter *= 2;
        this.height *= 2;
    }

    /**
     * 缩小行为，每次调用长度和半径减少一半
     */
    public void shrink() {
        this.diameter /= 2;
        this.height /= 2;
    }
}