package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/23 10:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8401Application {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401Application.class,args);
    }
}
