package com.example.demo.utils.DesignPattern.generate.singleton;

/**
 * @Author: likang
 * @Date: 2021/2/12 16:20
 */
public class DoubleCheck {

    private static volatile DoubleCheck instance = null;

    private DoubleCheck(){}

    public static DoubleCheck getInstance(){
        if(instance == null){
            synchronized (DoubleCheck.class){
                if(instance == null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
