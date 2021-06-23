package org.example.springcloud.service;

import org.example.springcloud.domain.Order;

/**
 * @Classname OrderService
 * @Description 账单
 * @Date 2021/6/7 16:37
 * @Created by wangjianping
 */
public interface OrderService {
    public void create(Order order);
}
