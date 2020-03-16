package com.sykean.springcloud.service;

import com.sykean.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 9:44
 */
public interface PaymentService {
    int save(Payment payment);

    Payment findById(@Param("id") Long id);
}
