package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 15:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerOrder84Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder84Application.class,args);
    }
}
