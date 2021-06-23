package org.example.springcloud.controller;

import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Classname AccountController
 * @Description 账户服务
 * @Date 2021/6/7 19:01
 * @Created by wangjianping
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("count") BigDecimal count){
        accountService.decrease(userId,count);
        return new CommonResult(200,"账户扣款成功");
    }

}
