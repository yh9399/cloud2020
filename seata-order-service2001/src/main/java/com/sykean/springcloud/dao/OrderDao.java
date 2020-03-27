package com.sykean.springcloud.dao;

import com.sykean.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ${yanghong}
 * @create 2020/3/25 17:36
 */
@Mapper
public interface OrderDao {
    /**
     * 新增
     * @param order
     */
    void  insert(Order order);

    /**
     * 修改订单状态
     * @param userId
     * @param status
     */
    void update(@Param("userId") String userId,@Param("status") Integer status);
}
