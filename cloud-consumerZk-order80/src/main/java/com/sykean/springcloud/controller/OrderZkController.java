package com.sykean.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/11 17:06
 */
@RestController
@Slf4j
public class OrderZkController {
    public static  final  String ZK_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get")
    public String getPayment(){
        return  restTemplate.getForObject(ZK_URL+"/payment/get",String.class);
    }
}
