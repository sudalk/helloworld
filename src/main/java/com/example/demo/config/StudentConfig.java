package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: likang
 * @Date: 2021/1/24 18:26
 */
@ConfigurationProperties(prefix = "person")
public class StudentConfig {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
