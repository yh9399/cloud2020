package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/18 14:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment9001Application.class,args);
    }
}
