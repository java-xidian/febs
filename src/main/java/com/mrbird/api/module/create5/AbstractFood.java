package com.mrbird.api.module.create5;

/**
 * 2. 抽象工厂模式（Abstract Factory）
 * 　　一个基础接口定义了功能，每个实现接口的子类就是产品，
 * 然后定义一个工厂接口，实现了工厂接口的就是工厂，这时候，
 * 接口编程的优点就出现了，我们可以新增产品类（只需要实现产品接口），
 * 只需要同时新增一个工厂类，客户端就可以轻松调用新产品的代码。
 * 抽象工厂的灵活性就体现在这里，无需改动原有的代码，毕竟对于客户端来说，静态工厂模式在不改动StaticFactory类的代码时无法新增产品，如果采用了抽象工厂模式，就可以轻松的新增拓展类。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/2/27
 */

/**
 * 1.一个基础接口定义了功能
 */
interface AbstractFood {
}

class Ab implements AbstractFood {
}

class Bc implements AbstractFood {
}

/**
 * 2.然后定义一个工厂接口,只需要同时新增一个工厂类，客户端就可以轻松调用新产品的代码
 */
interface produce {
    AbstractFood get();
}

class FactoryForA implements produce {
    @Override
    public AbstractFood get() {
        return new Ab();
    }
}

class FactoryForB implements produce {
    @Override
    public AbstractFood get() {
        return new Bc();
    }
}

class AbstractFactory {
    public void ClientCode(String name) {
        AbstractFood x = new FactoryForA().get();
        x = new FactoryForB().get();
    }
}