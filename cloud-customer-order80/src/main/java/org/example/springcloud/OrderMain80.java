package org.example.springcloud;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
//@MapperScan(basePackages = {"com.xxx.xxx.mapper"})
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
@EnableDiscoveryClient
public class OrderMain80 {

    public static void main(String[] args){
        // 运行spring应用
        SpringApplication.run(OrderMain80.class, args);
    }
}