package com.sykean.springcloud.service;

import com.sykean.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author ${yanghong}
 * @create 2020/3/13 16:05
 */
@Component
public class PaymentHystrixFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String ok(Integer id) {
        return "payment hystrix fallback for ok";
    }

    @Override
    public String timeOut(Integer id) {
        return "payment hystrix fallback for timeout";
    }
}
