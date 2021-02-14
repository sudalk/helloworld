package com.example.demo.utils.DesignPattern.struct.bridge;

/**
 * @Author: likang
 * @Date: 2021/2/13 21:30
 *
 * 类代表着属性
 *
 */
public class BagManage {

    public static void main(String[] args) {
        //颜色和包都是单元的
        Color color = new Yellow();
        Bag bag = new HandBag();
        //还能加很多包
        //还能加很多颜色
        //每个包都能匹配颜色
        bag.setColor(color);
        System.out.println(bag.getName());
    }
}


interface Color{
    String getColor();
}

class Yellow implements Color{

    @Override
    public String getColor() {
        return "黄色";
    }
}

class Red implements Color{

    @Override
    public String getColor() {
        return "红色";
    }
}


abstract class Bag{
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }
    public abstract String getName();
}

class HandBag extends Bag{

    @Override
    public String getName() {
        return color.getColor()+"handbag";
    }
}



