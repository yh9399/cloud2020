package com.sykean.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:10
 */
public interface StorageService {
    void decrease(@RequestParam("productId") String productId, @RequestParam("count")Integer count);
}
