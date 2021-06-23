package org.example.springcloud.service;

import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



/**
 * @Classname PaymentService
 * @Description sentinel-openfeign
 * @Date 2021/6/4 14:44
 * @Created by wangjianping
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
