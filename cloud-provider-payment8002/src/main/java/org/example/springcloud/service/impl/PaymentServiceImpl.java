package org.example.springcloud.service.impl;

import org.example.springcloud.dao.PaymentMapper;
import org.example.springcloud.entity.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentImpl
 * @Description TODO
 * @Date 2021/3/23 17:31
 * @Created by wangjianping
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }
    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
