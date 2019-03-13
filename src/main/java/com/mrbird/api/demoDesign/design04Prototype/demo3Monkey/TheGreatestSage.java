package com.mrbird.api.demoDesign.design04Prototype.demo3Monkey;

/**
 * 孙大圣的身外身法术
 * 　　孙大圣的身外身本领如果在Java语言里使用原型模式来实现的话，会怎么样呢？
 * 1.首先，齐天大圣(The Greatest Sage)即TheGreatestSage类扮演客户角色。
 * 齐天大圣持有一个猢狲（Monkey）的实例，而猢狲就是大圣本尊。
 * Monkey类具有继承自java.lang.Object的clone()方法，因此，可以通过调用这个克隆方法来复制一个Monkey实例。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class TheGreatestSage {
    private Monkey monkey = new Monkey();

    public void change() {
        //克隆大圣本尊
        Monkey copyMonkey = (Monkey) monkey.clone();
        System.out.println("大圣本尊的生日是：" + monkey.getBirthDate());
        System.out.println("克隆的大圣的生日是：" + monkey.getBirthDate());
        System.out.println("大圣本尊跟克隆的大圣是否为同一个对象 " + (monkey == copyMonkey));
        System.out.println("大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ " + (monkey.getStaff() == copyMonkey.getStaff()));
    }

    public static void main(String[] args) {
        TheGreatestSage sage = new TheGreatestSage();
        sage.change();
    }
}