package org.example.springcloud.controller;

import org.example.springcloud.domain.Order;
import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2021/6/7 17:48
 * @Created by wangjianping
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
