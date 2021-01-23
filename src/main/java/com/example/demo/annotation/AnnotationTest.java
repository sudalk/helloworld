package com.example.demo.annotation;

import org.springframework.stereotype.Component;

/**
 * @Author: likang
 * @Date: 2021/1/23 21:26
 */
@Link(cmd = "AnnotationTest")
@Component
public class AnnotationTest {

    @LinkM(sub = "test")
    public void test(){
        System.out.println("test annotation");
    }
}
