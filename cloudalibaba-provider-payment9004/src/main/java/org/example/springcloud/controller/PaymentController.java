package org.example.springcloud.controller;

import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2021/6/4 10:25
 * @Created by wangjianping
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //模拟数据库
    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static{
        hashMap.put(1L,new Payment(1L,"6e793b4f-c4dc-11eb-b555-c268a6db81da"));
        hashMap.put(2L,new Payment(2L,"7bcc86fc-c4dc-11eb-b555-c268a6db81da"));
        hashMap.put(3L,new Payment(3L,"8319ad69-c4dc-11eb-b555-c268a6db81da"));
    }


    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        if(payment==null){
            throw new IllegalArgumentException("没有id对应的数据");
        }
        CommonResult<Payment> result=new CommonResult<>(200,"from mysql,serverPort:"+serverPort,payment);
        return result;
    }
}
