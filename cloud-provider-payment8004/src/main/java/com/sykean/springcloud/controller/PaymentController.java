package com.sykean.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author ${yanghong}
 * @create 2020/3/11 14:10
 */
@RestController
@RequestMapping("/payment")
//@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/get")
    public  String getZk(){
        return  "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
