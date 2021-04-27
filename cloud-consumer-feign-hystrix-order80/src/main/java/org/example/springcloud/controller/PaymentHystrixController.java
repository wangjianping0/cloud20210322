package org.example.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.service.PaymentFeignHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname PaymentHystrixController
 * @Description TODO
 * @Date 2021/4/15 17:31
 * @Created by wangjianping
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback="payment_Global_FallbackMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentFeignService.paymentInfo_OK(id);
        log.info("****paymentInfo_OK****result:"+result);
        return result;
    }
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutFallbackMethod",commandProperties={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand //加了@DefaultProperties属性注解,并且没有写具体方法名字,就用统一全局的
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int num=10/0;
        String result=paymentFeignService.paymentInfo_TimeOut(id);
        log.info("****paymentInfo_TimeOut****result:"+result);
        return result;
    }
    public String paymentInfo_TimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试,或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
    public String payment_Global_FallbackMethod(){
        return "Global异常处理,请稍后重试,/ToT/~~";
    }
}
