package org.example.springcloud.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.dao.OrderDao;
import org.example.springcloud.domain.Order;
import org.example.springcloud.service.AccountService;
import org.example.springcloud.service.OrderService;
import org.example.springcloud.service.StorageService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname OrderServiceImpl
 * @Description 账单
 * @Date 2021/6/7 16:39
 * @Created by wangjianping
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Resource
    private ApplicationContext applicationContext;
    @Override
    @GlobalTransactional(name = "test",rollbackFor=Exception.class)
    public void create(Order order) {
        //1.新建订单
        log.info("--->开始新建订单");
        orderDao.create(order);
        //2.扣减库存
        log.info("--->订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        //3.扣减账户
        log.info("--->订单微服务开始调用账户,做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("--->修改订单状态开始");
        //4.修改订单状态,0:创建中;1:已完结
        orderDao.update(order.getUserId(),0);
        log.info("--->修改订单状态结束");

        log.info("--->下订单结束了,O(∩_∩)O哈哈~");
    }
}
