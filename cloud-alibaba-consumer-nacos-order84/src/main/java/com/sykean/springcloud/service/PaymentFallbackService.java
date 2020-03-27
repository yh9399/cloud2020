package com.sykean.springcloud.service;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 16:54
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public Response<Payment> paymentSQL(Long id) {
        return new Response<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
