package com.example.demo.utils.DesignPattern.generate.factory.factorymethod;

/**
 * @Author: likang
 * @Date: 2021/2/12 22:42
 */
public class MethodFactory {
    /**
     * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。
     *灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
     *典型的解耦框架。把工厂抽象出来，一个产品对应一个工厂类
     *
     * 缺点：
     * 类的个数容易过多，增加复杂度
     *  抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。
     */

    public static void main(String[] args) {

        CattleTuFu cattleTuFu = new CattleTuFu();
        cattleTuFu.getAnimal().show();

        HorseTuFu horseTuFu = new HorseTuFu();
        horseTuFu.getAnimal().show();

    }
}
