package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigMain3344 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(SpringCloudConfigMain3344.class, args);
    }
}