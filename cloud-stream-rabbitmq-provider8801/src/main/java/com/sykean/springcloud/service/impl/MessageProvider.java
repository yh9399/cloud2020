package com.sykean.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.sykean.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Author ${yanghong}
 * @create 2020/3/17 15:43
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
