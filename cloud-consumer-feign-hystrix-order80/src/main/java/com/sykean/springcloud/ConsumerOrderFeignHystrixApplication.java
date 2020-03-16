package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ${yanghong}
 * @create 2020/3/13 11:40
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerOrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignHystrixApplication.class,args);
    }
}
