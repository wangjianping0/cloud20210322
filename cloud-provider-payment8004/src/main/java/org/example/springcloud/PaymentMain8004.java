package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient   //该注解用于向使用consul或者zookeeper作为注册中心时使用
public class PaymentMain8004 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(PaymentMain8004.class, args);
    }
}