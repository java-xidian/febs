package com.mrbird.api.demoThread.thread2;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/3/29
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CallbackDemo {
    public static void main(String[] args) {
        CallbackDemo 雇主 = new CallbackDemo();


        TimeWatcher 观察者 = new TimeWatcher();
        //雇主与观察者建立雇佣关系
        观察者.setCallback(雇主);
        //观察者开始开始工作
        观察者.start();
    }

    public void onCallback(String dateTime) {
        System.out.println("雇主接收到观察者回送的消息：" + dateTime);
    }
}

class TimeWatcher extends Thread {
    private CallbackDemo callback;

    public void setCallback(CallbackDemo callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (callback != null) {
                    //观察者通过调用CallbackDemo对象的onCallback方法回送消息到雇主那里
                    callback.onCallback(new Date().toString());
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

