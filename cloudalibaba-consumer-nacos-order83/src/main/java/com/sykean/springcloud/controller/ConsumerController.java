package com.sykean.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ${yanghong}
 * @create 2020/3/18 17:55
 */
@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    //从配置文件读取配置信息，相当于 public static  final String PAYMENT_URL="http://nacos-payment-provider";
    @Value("${service-url.nacos-user-service}")
    private String paymentUri;
    @GetMapping("/consumer/getPaymentInfo/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id ){
        String res=  restTemplate.getForObject(paymentUri+"/payment/nacos/"+id,String.class);
        return  "查看结果为："+res+"\t"+"服务端口号为: "+serverPort;
    }
}
