package com.sykean.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/16 17:32
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private  String configInfo;

    @GetMapping("/config/client/getConfigInfo")
    public String getConfigInfo(){
        log.info("*********config信息："+configInfo);
        return  configInfo;
    }
}
