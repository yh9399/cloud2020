package com.sykean.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    /**
     * 账户id
     */
    private  String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
