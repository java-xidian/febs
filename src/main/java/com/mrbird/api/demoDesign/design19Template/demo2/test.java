package com.mrbird.api.demoDesign.design19Template.demo2;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/10
 */
public abstract class test {
    static  abstract void java();

    static public void main(String[] args) {
        java();
    }
}


class test1 extends test {
    @Override
    static public void java() {
        System.out.println("java1");
    }

}

class test2 extends test {
    @Override
    static public void java() {
        System.out.println("java1");
    }
}