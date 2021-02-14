package com.example.demo.utils.DesignPattern.generate.factory.simple;

/**
 * @Author: likang
 * @Date: 2021/2/12 22:25
 */
public class SimpleFactory {

    /**
     * 简单工厂模式，工厂根据指定类型的产品升产指定的产品
     * 缺点：
     * 简单工厂模式使用了 static 工厂方法，比较臃肿，其次比较难以维护和修改，逻辑职责太多，各个产品混一起
     */
    static final int PRODUCT_A = 0;
    static final int PRODUCT_B = 1;
    static final int PRODUCT_C = 2;


    public static SimpleProduct makeProduct(int kind) {
        switch (kind) {
            case PRODUCT_A:
                return new ConcreteProductA();
            case PRODUCT_B:
                return new ConcreteProductB();
        }
        return null;
    }
    public static void main(String[] args) {
        makeProduct(0).show();
        makeProduct(1).show();
    }
}
