package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2021/3/25 15:50
 * @Created by wangjianping
 */
@RestController
@RequestMapping(value ="/customer/payment")
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL="http://localhost:8001";
//    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
        return result;
    }

}
