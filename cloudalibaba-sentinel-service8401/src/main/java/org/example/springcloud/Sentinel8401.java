package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(Sentinel8401.class, args);
    }
}