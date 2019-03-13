package com.mrbird.api.demoDesign.design03Build.demo3InsuranceContract;

/**
 * 　　在本例中将具体建造者合并到了产品对象中，并将产品对象的构造函数私有化，
 * 防止客户端不使用构建器来构建产品对象，而是直接去使用new来构建产品对象所导致的问题。
 * 另外，这个构建器的功能就是为了创建被构建的对象，完全可以不用单独一个类。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class Client {
    public static void main(String[] args) {
        //1.创建构建器对象
        InsuranceContract.ConcreteBuilder builder =
                new InsuranceContract.ConcreteBuilder("9527", 123L, 456L);
        //2.设置需要的数据，然后构建保险合同对象
        InsuranceContract contract =
                builder.setPersonName("小明").setOtherData("test").build();
        //3.操作保险合同对象的方法
        contract.someOperation();
    }
}
