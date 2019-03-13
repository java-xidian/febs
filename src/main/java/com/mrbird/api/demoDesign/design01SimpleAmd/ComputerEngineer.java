package com.mrbird.api.demoDesign.design01SimpleAmd;

/**
 * 装机工程师类与客户类运行结果如下
 * <p>
 * 考虑客户的功能，需要选择自己需要的CPU和主板，然后告诉装机工程师自己的选择，接下来就等着装机工程师组装电脑了。
 * 对装机工程师而言，只是知道CPU和主板的接口，而不知道具体实现，
 * 很明显可以用上简单工厂模式或工厂方法模式。
 * 为了简单，这里选用简单工厂。
 * 客户告诉装机工程师自己的选择，然后装机工程师会通过相应的工厂去获取相应的实例对象。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/3/1
 */
public class ComputerEngineer {
    /**
     * 定义组装机需要的CPU
     */
    private Cpu cpu = null;
    /**
     * 定义组装机需要的主板
     */
    private Mainboard mainboard = null;

    public void makeComputer(int cpuType, int mainboard) {
        /**
         * 组装机器的基本步骤
         */
        //1:首先准备好装机所需要的配件
        prepareHardwares(cpuType, mainboard);
        //2:组装机器
        //3:测试机器
        //4：交付客户
    }

    private void prepareHardwares(int cpuType, int mainboard) {
        //这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？

        //直接找相应的工厂获取
        this.cpu = CpuFactory.createCpu(cpuType);
        this.mainboard = MainboardFactory.createMainboard(mainboard);

        //测试配件是否好用
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
