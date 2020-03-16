package com.sykean.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ${yanghong}
 * @create 2020/3/13 11:42
 */
@Component
@FeignClient(value = "cloud-payment-hystrix-service",fallback = PaymentHystrixFallbackServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id );

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String timeOut(@PathVariable("id")Integer id );
}
