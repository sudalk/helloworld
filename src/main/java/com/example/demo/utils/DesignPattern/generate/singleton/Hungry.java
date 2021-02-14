package com.example.demo.utils.DesignPattern.generate.singleton;

/**
 * @Author: likang
 * @Date: 2021/2/12 16:24
 */
public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry(){}

    public static Hungry getInstance(){
        return instance;
    }
}
