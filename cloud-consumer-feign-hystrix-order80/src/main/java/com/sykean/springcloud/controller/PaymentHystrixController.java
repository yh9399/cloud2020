package com.sykean.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sykean.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ${yanghong}
 * @create 2020/3/13 11:45
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalHandle")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id ){
        String res=paymentHystrixService.ok(id);
        return  res;
    }
//    @HystrixCommand(fallbackMethod = "errorHandle", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    public String timeOut(@PathVariable("id")Integer id ){
        String res=paymentHystrixService.timeOut(id);
        return  res;
    }
    public String errorHandle(Integer id ) {

        return "消费者80访问生产者8001繁忙或检查自己是否出错";
    }

    public String globalHandle(){
        return  "Global处理异常，请稍后再试";
    }
}
