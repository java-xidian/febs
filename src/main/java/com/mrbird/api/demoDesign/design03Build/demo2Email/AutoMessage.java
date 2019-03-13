package com.mrbird.api.demoDesign.design03Build.demo2Email;

import java.util.Date;

/**
 * 　　假设有一个电子杂志系统，定期地向用户的电子邮件信箱发送电子杂志。用户可以通过网页订阅电子杂志，也可以通过网页结束订阅。当客户开始订阅时，系统发送一个电子邮件表示欢迎，当客户结束订阅时，系统发送一个电子邮件表示欢送。本例子就是这个系统负责发送“欢迎”和“欢送”邮件的模块。
 * 　　在本例中，产品类就是发给某个客户的“欢迎”和“欢送”邮件，如下图所示。
 * <p>
 * 抽象类AutoMessage源代码，send()操作仅仅是示意性的，并没有给出任何发送电子邮件的代码。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public abstract class AutoMessage {
    //收件人地址
    private String to;
    //发件人地址
    private String from;
    //标题
    private String subject;
    //内容
    private String body;
    //发送日期
    private Date sendDate;

    public void send() {
        System.out.println("收件人地址：" + to);
        System.out.println("发件人地址：" + from);
        System.out.println("标题：" + subject);
        System.out.println("内容：" + body);
        System.out.println("发送日期：" + sendDate);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

}