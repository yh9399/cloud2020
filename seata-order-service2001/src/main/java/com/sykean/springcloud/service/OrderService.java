package com.sykean.springcloud.service;

import com.sykean.springcloud.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 11:47
 */
public interface OrderService {
    /**
     * 新增
     * @param order
     */
    void  insert(Order order);
}
