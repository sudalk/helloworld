package com.example.demo;

import com.example.demo.annotation.ScanTest;
import com.example.demo.dao.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScanTest scanTest;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        logger.debug("debug");
        logger.info("info");
        User user = new User();
        user.setLogName("123");
        user.setPasswd("456");
        user.setSex("1");
        userMapper.insert(user);
    }

    @Test
    public void redisTest(){
        String a = "校草";
        redisUtil.set("lk", a);
        System.out.println("succeed");
        System.out.println(redisUtil.get("lk"));
    }

    @Test
    public void scantest() throws Exception {
        scanTest.scantest();
    }



}
