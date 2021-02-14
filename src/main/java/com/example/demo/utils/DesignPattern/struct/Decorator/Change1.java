package com.example.demo.utils.DesignPattern.struct.Decorator;

/**
 * @Author: likang
 * @Date: 2021/2/13 22:12
 */
public class Change1 implements Component{

    private Component component;

    public Change1(Component component) {
        this.component = component;
    }

    @Override
    public void show() {
        component.show();
        System.out.println("第一个变化");
    }
}
