package org.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname CloudConfigServerMain3344
 * @Description TODO
 * @Date 2021/5/6 14:53
 * @Created by wangjianping
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerMain3344.class,args);
    }
}
