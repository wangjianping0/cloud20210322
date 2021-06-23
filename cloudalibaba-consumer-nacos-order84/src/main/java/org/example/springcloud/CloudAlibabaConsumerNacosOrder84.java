package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaConsumerNacosOrder84 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(CloudAlibabaConsumerNacosOrder84.class, args);
    }
}