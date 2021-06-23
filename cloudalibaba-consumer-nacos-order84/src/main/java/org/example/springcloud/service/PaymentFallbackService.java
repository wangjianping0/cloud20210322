package org.example.springcloud.service;

import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description 服务降级
 * @Date 2021/6/4 14:53
 * @Created by wangjianping
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(44444,"服务降级返回,-------PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
