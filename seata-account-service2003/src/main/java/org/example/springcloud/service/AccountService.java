package org.example.springcloud.service;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2021/6/7 19:02
 * @Created by wangjianping
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal count);
}
