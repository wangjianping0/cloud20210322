package org.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2021/4/17 15:12
 * @Created by wangjianping
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService.paymentInfo_OK()";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService.paymentInfo_TimeOut()";
    }
}
