package com.sykean.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    /**
     * 库存id
     */
    private String id;

    /**
     * 产品id
     */
    private  String productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
