package com.example.demo.utils.DesignPattern.generate.singleton;

/**
 * @Author: likang
 * @Date: 2021/2/12 16:18
 */
public class Lazy {

    private static volatile Lazy instance  = null;

    private Lazy(){

    }

    //  public static synchronized
    public static Lazy getInstance(){
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }
}
