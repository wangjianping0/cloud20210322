package com.example.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname RestDemo
 * @Description TODO
 * @Date 2021/3/25 16:15
 * @Created by wangjianping
 */
@SpringBootTest
public class RestDemo {
    @Resource
    private RestTemplate restTemplate;



}
