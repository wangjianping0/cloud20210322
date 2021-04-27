package org.example.springcloud.service;

import org.example.springcloud.entity.Payment;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2021/3/23 17:30
 * @Created by wangjianping
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
