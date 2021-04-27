package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderFeignController
 * @Description TODO
 * @Date 2021/4/15 11:12
 * @Created by wangjianping
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentTimeout() {
        //openfeign-ribbon ,客户端默认等待1秒钟
        return paymentFeignService.paymentTimeout();
    }
}
