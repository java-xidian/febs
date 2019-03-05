package com.mrbird.api.module.design03Build.demo2Email;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class GoodbyeBuilder extends Builder {

    public GoodbyeBuilder() {
        msg = new GoodbyeMessage();
    }

    @Override
    public void buildBody() {
        // TODO Auto-generated method stub
        msg.setBody("欢送内容");
    }

    @Override
    public void buildSubject() {
        // TODO Auto-generated method stub
        msg.setSubject("欢送标题");
    }

}
