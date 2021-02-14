package com.example.demo.utils.DesignPattern.generate.factory.abstractfactory;

/**
 * @Author: likang
 * @Date: 2021/2/13 1:04
 */
public class SRfarm implements Farm {
    public Animal newAnimal() {
        System.out.println("新马出生！");
        return new Horse1();
    }
    public Plant newPlant() {
        System.out.println("水果长成！");
        return new Fruitage();
    }
}
