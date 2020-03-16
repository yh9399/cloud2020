package com.sykean.springcloud.controller;

import com.sykean.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/13 10:32
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private  String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id ){
       String res=paymentHystrixService.ok(id);
       return  res;
    }
    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String timeOut(@PathVariable("id")Integer id ){
        String res=paymentHystrixService.timeOut(id);
        return  res;
    }
    @GetMapping("/payment/hystrix/paymentCircuitBreake/{id}")
    public  String paymentCircuitBreake(@PathVariable("id") Integer id){
      String res=paymentHystrixService.paymentCircuitBreake(id);
      return  res;
    }

}
