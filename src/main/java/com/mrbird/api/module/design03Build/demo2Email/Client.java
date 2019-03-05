package com.mrbird.api.module.design03Build.demo2Email;

/**
 * 　　1.假设有一个电子杂志系统，定期地向用户的电子邮件信箱发送电子杂志。
 * 用户可以通过网页订阅电子杂志，也可以通过网页结束订阅。
 * 当客户开始订阅时，系统发送一个电子邮件表示欢迎，
 * 当客户结束订阅时，系统发送一个电子邮件表示欢送。
 * 本例子就是这个系统负责发送“欢迎”和“欢送”邮件的模块。
 * <p>
 * 2.不管如何变化，建造模式都存在这么两个部分，
 * 一个部分是部件构造和产品装配，
 * 另一个部分是整体构建的算法。
 * 认识这点是很重要的，因为在建造模式中，强调的是固定整体构建的算法，而灵活扩展和切换部件的具体构造和产品装配的方式。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@126.com", "fromAddress@126.com");

    }
}
