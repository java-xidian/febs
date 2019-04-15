package com.mrbird.api.utils.functionTest;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/15
 */
public class PersonStatic {

    static {
        System.out.println("1.我是静态块，优先于构造块执行！并且只有创建第一个对象的时候执行一次！");
    }

    {
        System.out.println("2.我是构造块，优先于构造方法执行！每创建一个对象执行一次！");
    }

    public PersonStatic() {
        System.out.println("3.我是构造方法，每创建一个对象执行一次");
    }

    public void function1() {
        System.out.println("我是非静态方法中的普通代码块，方法被调用时执行！");
    }

    public static void function2() {
        System.out.println("我是静态方法中的普通代码块，方法被调用时执行，晚于静态块执行！");
    }

    static class HelloWrold {
        public static void main(String[] args) {
            new PersonStatic().function1();
            System.out.println("=================");
            new PersonStatic().function1();
            System.out.println("=================");
            PersonStatic.function2();
            System.out.println("=================");
            PersonStatic.function2();
        }
    }
}
