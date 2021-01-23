package com.example.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: likang
 * @Date: 2021/1/23 21:37
 */
public class AnnotationConfig {

    public static void main(String[] args) throws ClassNotFoundException {
        //Class<?> clz = AnnotationTest.class;
        Class<?> clz = Class.forName("com.example.demo.annotation.AnnotationTest");
        Annotation[] annotations = clz.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        Method[] methods = clz.getMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(LinkM.class)){
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                System.out.println(Arrays.toString(declaredAnnotations));
            }
        }
    }


}
