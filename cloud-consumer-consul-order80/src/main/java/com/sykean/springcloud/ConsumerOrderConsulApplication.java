package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 10:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderConsulApplication.class,args);
    }
}
