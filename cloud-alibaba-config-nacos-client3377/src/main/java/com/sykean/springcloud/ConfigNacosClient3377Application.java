package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/19 10:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacosClient3377Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosClient3377Application.class,args);
    }
}
