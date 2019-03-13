package com.mrbird.api.demoDesign.design01SimpleAmd;

/**
 * 　　上面的实现，虽然通过简单工厂方法解决了：
 * 对于装机工程师，只知CPU和主板的接口，而不知道具体实现的问题。但还有一个问题没有解决，
 * 那就是这些CPU对象和主板对象其实是有关系的，需要相互匹配的。
 * 而上面的实现中，并没有维护这种关联关系，CPU和主板是由客户任意选择，这是有问题的。
 * 比如在客户端调用makeComputer时，传入参数为(1,2)，运行结果如下：
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Client {
    public static void main(String[] args) {
        ComputerEngineer cf = new ComputerEngineer();
        cf.makeComputer(1, 1);
        cf.makeComputer(1, 2);
    }
}
