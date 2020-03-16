package com.sykean.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 10:09
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private  static  final  String CONSUL_URL="http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/getConsul")
    public  Object getConsul(){
        return  restTemplate.getForObject(CONSUL_URL+"/payment/getConsul",String.class);
    }
}
