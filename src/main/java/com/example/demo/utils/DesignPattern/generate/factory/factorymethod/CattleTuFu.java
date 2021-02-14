package com.example.demo.utils.DesignPattern.generate.factory.factorymethod;

/**
 * @Author: likang
 * @Date: 2021/2/13 0:38
 */
public class CattleTuFu implements TuFu{
    @Override
    public Animal getAnimal() {
        return new Cattle();
    }
}
