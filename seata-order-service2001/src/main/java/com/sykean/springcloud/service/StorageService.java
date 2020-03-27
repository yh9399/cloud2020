package com.sykean.springcloud.service;

import com.sykean.springcloud.common.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 11:52
 */
@FeignClient("seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    Response decrease(@RequestParam("productId") String productId,@RequestParam("count") Integer count);
}
