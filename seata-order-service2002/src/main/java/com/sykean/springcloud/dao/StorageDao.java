package com.sykean.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:08
 */
@Mapper
public interface StorageDao {

    /**
     * 修改库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") String productId, @Param("count") Integer count);
}
