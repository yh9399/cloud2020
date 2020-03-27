package com.sykean.springcloud.service;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 16:52
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public Response<Payment> paymentSQL(@PathVariable("id") Long id);
}
