package com.example.demo.config;

import com.example.demo.dao.StudentTest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: likang
 * @Date: 2021/1/24 18:24
 */
@Configuration
@EnableConfigurationProperties({StudentConfig.class})
public class NewStartConfig {

    @Bean
    public StudentTest studentTest(StudentConfig studentConfig){
        StudentTest studentTest = new StudentTest();
        studentTest.setId(studentConfig.getId());
        return studentTest;
    }
}
