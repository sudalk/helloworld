package com.example.demo.utils.DesignPattern.struct.Decorator;

/**
 * @Author: likang
 * @Date: 2021/2/13 22:12
 */
public class Change2 implements Component{

    private Component component;

    public Change2(Component component) {
        this.component = component;
    }

    @Override
    public void show() {
        component.show();
        System.out.println("第二个变化");
    }
}
