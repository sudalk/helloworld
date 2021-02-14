package com.example.demo.utils.DesignPattern.generate.factory.abstractfactory;

/**
 * @Author: likang
 * @Date: 2021/2/13 1:03
 */
public class SGfarm implements Farm {
    public Animal newAnimal() {
        System.out.println("新牛出生！");
        return new Cattle1();
    }
    public Plant newPlant() {
        System.out.println("蔬菜长成！");
        return new Vegetables();
    }
}
