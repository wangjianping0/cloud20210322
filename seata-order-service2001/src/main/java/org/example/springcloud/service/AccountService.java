package org.example.springcloud.service;

import org.example.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description 账户
 * @Date 2021/6/7 16:38
 * @Created by wangjianping
 */
@Component
@FeignClient(value="seata-account-service")
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("count") BigDecimal count);
}
