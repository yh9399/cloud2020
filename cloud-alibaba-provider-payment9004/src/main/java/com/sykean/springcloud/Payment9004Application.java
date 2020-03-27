package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 15:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9004Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment9004Application.class,args);
    }
}
