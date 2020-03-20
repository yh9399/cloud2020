package com.sykean.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/19 10:12
 */
@RestController
@RefreshScope
public class ConfigNacosController {
    @Value("${config.info}")
    private  String configInfo;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return  configInfo;
    }
}
