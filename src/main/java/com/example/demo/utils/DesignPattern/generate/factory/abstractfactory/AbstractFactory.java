package com.example.demo.utils.DesignPattern.generate.factory.abstractfactory;

/**
 * @Author: likang
 * @Date: 2021/2/13 0:47
 */
public class AbstractFactory {

    /**
     * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
     * 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
     * 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。
     *
     */


    public static void main(String[] args) {
        Farm sGfarm = new SGfarm();
        Farm sRfarm = new SRfarm();

        sGfarm.newAnimal();
        sGfarm.newPlant();

        sRfarm.newAnimal();
        sRfarm.newPlant();
    }
}
