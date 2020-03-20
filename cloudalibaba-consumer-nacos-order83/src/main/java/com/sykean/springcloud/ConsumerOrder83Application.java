package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/18 17:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrder83Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder83Application.class,args);
    }
}
