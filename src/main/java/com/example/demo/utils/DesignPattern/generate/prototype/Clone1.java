package com.example.demo.utils.DesignPattern.generate.prototype;

/**
 * @Author: likang
 * @Date: 2021/2/12 20:30
 */


public class Clone1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1 == obj2 ? " + (obj1 == obj2));

    }
}
