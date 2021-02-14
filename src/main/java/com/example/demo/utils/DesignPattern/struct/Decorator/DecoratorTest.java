package com.example.demo.utils.DesignPattern.struct.Decorator;

/**
 * @Author: likang
 * @Date: 2021/2/13 22:15
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Component original = new Original();
        Component change1 = new Change1(original);
        Component change2 = new Change2(change1);
        change2.show();
    }
}
