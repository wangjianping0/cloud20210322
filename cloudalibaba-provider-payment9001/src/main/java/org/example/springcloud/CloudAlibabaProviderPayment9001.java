package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment9001 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(CloudAlibabaProviderPayment9001.class, args);
    }
}