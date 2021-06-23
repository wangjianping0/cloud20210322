package org.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Classname ReceiveMessageListenerController
 * @Description TODO
 * @Date 2021/5/17 10:35
 * @Created by wangjianping
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        System.out.println("消费者4号*****************接受到的消息:"+message.getPayload()+"\t serverPort:"+serverPort);
    }

}
