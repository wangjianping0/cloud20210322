package org.example.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.dao.AccountDao;
import org.example.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Classname AccountServiceImpl
 * @Description TODO
 * @Date 2021/6/7 19:04
 * @Created by wangjianping
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal count) {
        //账户扣款
        log.info("--->账户扣款");
        accountDao.decrease(userId,count);
        log.info("--->账户扣款结束");
    }
}
