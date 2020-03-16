package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 16:35
 */
@RestController
public class ConsumerFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public Response<Payment> findById(@PathVariable("id") Long id){
        return  paymentFeignService.findById(id);
    }
    @GetMapping("/consumer/payment/timeout")
    public String timeout(){
        return  paymentFeignService.timeout();
    }
}
