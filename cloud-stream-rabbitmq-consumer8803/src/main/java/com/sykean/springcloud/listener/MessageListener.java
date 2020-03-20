package com.sykean.springcloud.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author ${yanghong}
 * @create 2020/3/17 16:56
 */
@Component
@EnableBinding(Sink.class) //绑定服务消费
public class MessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("服务消费者接收到的消息为："+message.getPayload()+"\t"+"当前服务端口号为："+serverPort);

    }

}