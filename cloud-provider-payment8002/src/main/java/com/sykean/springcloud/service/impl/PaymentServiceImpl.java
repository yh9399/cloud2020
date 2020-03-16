package com.sykean.springcloud.service.impl;

import com.sykean.springcloud.dao.PaymentDao;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 10:12
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int save(Payment payment) {
        int res=paymentDao.save(payment);
        return res;
    }


    public Payment findById(Long id) {
        Payment pay=paymentDao.findById(id);
        return pay;
    }
}
