package org.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.entity.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname CircleBreakerController
 * @Description TODO
 * @Date 2021/6/4 11:26
 * @Created by wangjianping
 */
@RestController
@Slf4j
public class CircleBreakerController {
    private static final String SERVICE_URL = "http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallBack")//只负责异常配置
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallBack",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallBack", blockHandler = "blockHandler", exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> forObject = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常......");
        } else if (forObject.getData() == null) {
            throw new NullPointerException("NullPointerException,该id没有对应记录,空指针异常......");
        }
        return forObject;
    }

    public CommonResult<Payment> handlerFallBack(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常handlerFallBack,exceprion内容:" + e.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "blockHandler-sentinel限流,无此流水:BlockException:" + e.getMessage(), payment);
    }

    //-------------------------openfeign
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }
}
