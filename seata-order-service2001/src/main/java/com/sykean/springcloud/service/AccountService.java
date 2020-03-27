package com.sykean.springcloud.service;

import com.sykean.springcloud.common.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 13:38
 */
@FeignClient("seata-account-service")
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    Response decrease(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);

}
