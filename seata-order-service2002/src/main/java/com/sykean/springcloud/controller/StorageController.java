package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:16
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public Response decrease(String productId,Integer count){
        storageService.decrease(productId,count);
        return  new Response(200,"扣减库存成功");
    }
}
