package com.mrbird.api.demoDesign.design02Abstract;

/**
 * 1.抽象工厂的功能是为一系列相关对象或相互依赖的对象创建一个接口。
 * 一定要注意，这个接口内的方法不是任意堆砌的，而是一系列相关或相互依赖的方法。
 * 比如上面例子中的主板和CPU，都是为了组装一台电脑的相关对象。
 * 不同的装机方案，代表一种具体的电脑系列。
 * <p>
 * <p>同一个产品组
 * <p>
 * 2.由于抽象工厂定义的一系列对象通常是相关或相互依赖的，这些产品对象就构成了一个产品族，也就是抽象工厂定义了一个产品族。
 * 这就带来非常大的灵活性，切换产品族的时候，只要提供不同的抽象工厂实现就可以了，
 * 也就是说现在是以一个产品族作为一个整体被切换。
 * <p>
 * 3.优点
 * <p>
 * 使切换产品族变得容易
 * 　　因为一个具体的工厂实现代表的是一个产品族，比如上面例子的从Intel系列到AMD系列只需要切换一下具体工厂。
 * 4.
 * 每一个模式都是针对一定问题的解决方案。抽象工厂模式与工厂方法模式的最大区别就在于，
 * 工厂方法模式针对的是一个产品等级结构；而抽象工厂模式则需要面对多个产品等级结构。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Client {
    public static void main(String[] args) {
        //创建装机工程师对象
        ComputerEngineer cf = new ComputerEngineer();
        //客户选择并创建需要使用的产品对象
        AbstractFactory abstractFactory = new IntelFactory();
        //告诉装机工程师自己选择的产品，让装机工程师组装电脑
        cf.makeComputer(abstractFactory);
    }
}
