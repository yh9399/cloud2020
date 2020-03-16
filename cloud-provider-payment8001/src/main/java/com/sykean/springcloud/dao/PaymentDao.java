package com.sykean.springcloud.dao;

import com.sykean.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 9:42
 */
@Mapper
public interface PaymentDao {
     int save(Payment payment);

     Payment findById(@Param("id")Long id);
}
