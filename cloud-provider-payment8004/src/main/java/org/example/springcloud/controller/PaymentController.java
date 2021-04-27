package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2021/4/6 15:34
 * @Created by wangjianping
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value(value = "${server.port}")
    private String serverPort;


    @GetMapping("/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:" +serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
