package com.example.demo.utils.DesignPattern.struct.Decorator;

/**
 * @Author: likang
 * @Date: 2021/2/13 22:11
 */
public class Original implements Component{

    @Override
    public void show() {
        System.out.println("初始状态");
    }
}
