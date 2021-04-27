package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 启动类
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(ConsumerHystrixDashboard9001.class, args);
    }
}