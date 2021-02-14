package com.example.demo.utils.DesignPattern.generate.factory.factorymethod;

/**
 * @Author: likang
 * @Date: 2021/2/13 0:37
 */
public class HorseTuFu implements TuFu{
    @Override
    public Animal getAnimal() {
        return new Horse();
    }
}
