package com.example.demo.utils.DesignPattern.generate.singleton;

/**
 * @Author: likang
 * @Date: 2021/2/12 16:25
 */
public class StaticClass {

    private StaticClass(){}

    public static StaticClass getInstance(){
        return StaticSingle.instance;
    }


    private static class StaticSingle{
        private static final StaticClass instance = new StaticClass();
    }

}
