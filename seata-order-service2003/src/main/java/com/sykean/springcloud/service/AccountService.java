package com.sykean.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:50
 */
public interface AccountService {
    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") String userId, @Param("money") BigDecimal money);
}
