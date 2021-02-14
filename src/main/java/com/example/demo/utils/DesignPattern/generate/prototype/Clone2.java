package com.example.demo.utils.DesignPattern.generate.prototype;

import java.io.*;

/**
 * @Author: likang
 * @Date: 2021/2/12 20:31
 */
public class Clone2 {

    public static <T extends Serializable> T clone (T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(bao);
        outputStream.writeObject(obj);
        ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(bai);
        Object o = inputStream.readObject();
        return (T) o;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Realizetype obj1 = new Realizetype();
        obj1.setName("lklk");
        Realizetype obj2 = clone(obj1);
        System.out.println("obj1 == obj2 ? " + (obj1 == obj2));
        System.out.println(obj2.getName());
    }
}
