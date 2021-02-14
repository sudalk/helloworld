package com.example.demo.utils.DesignPattern.generate.prototype;

import java.io.Serializable;

/**
 * @Author: likang
 * @Date: 2021/2/12 21:13
 */
public class Realizetype  implements Cloneable, Serializable {

        private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Realizetype (){
            System.out.println("克隆clone");
        }
        public Object clone() throws CloneNotSupportedException {
            System.out.println("原型复制");
            return (com.example.demo.utils.DesignPattern.generate.prototype.Realizetype)super.clone();
        }
}
