package org.example.springcloud.controller;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2021/3/23 17:53
 * @Created by wangjianping
 */

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.entity.Payment;
import org.example.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value(value = "${server.port}")
    private String serverPort;


    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("PaymentController.create(),param:{}, userId:{}, isAdmin:{}", JSON.toJSONString(payment), null, null);
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败,serverPort:"+serverPort);
        }
    }
    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        log.info("PaymentController.create(),param:{}, userId:{}, isAdmin:{}", id, null, null);
        Payment result=paymentService.getPaymentById(id);
        System.out.println(JSON.toJSONString(result));
        if(result==null){
            return new CommonResult(444,"查询失败,serverPort:"+serverPort);
        }else{
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,result);
        }
    }

    @GetMapping("/descovery")
    public Object discovery(){

        //服务列表
        List<String> services = discoveryClient.getServices();
        services.forEach(service->{
            log.info(service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(serviceInstance -> {
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        });
        return this.discoveryClient;
    }
    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping(value = "/feign/timeout")
    public String paymentTimeout(){
        //暂停几秒钟线程
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
