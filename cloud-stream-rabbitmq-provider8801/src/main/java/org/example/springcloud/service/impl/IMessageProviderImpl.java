package org.example.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import org.example.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @Classname IMessageProviderImpl
 * @Description TODO
 * @Date 2021/5/14 15:53
 * @Created by wangjianping
 */
@EnableBinding(Source.class)//定义消息推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {

        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*************serial:"+serial);
        return null;
    }
}
