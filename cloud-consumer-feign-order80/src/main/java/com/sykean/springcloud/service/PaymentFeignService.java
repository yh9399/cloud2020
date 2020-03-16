package com.sykean.springcloud.service;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 16:34
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
   public  Response<Payment> findById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String timeout();
}
