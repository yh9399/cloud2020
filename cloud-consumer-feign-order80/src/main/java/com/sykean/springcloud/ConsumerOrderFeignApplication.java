package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 16:23
 */
@SpringBootApplication
//开启feign客户端
@EnableFeignClients
public class ConsumerOrderFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignApplication.class,args);
    }
}
