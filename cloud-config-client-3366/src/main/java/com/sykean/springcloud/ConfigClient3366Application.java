package com.sykean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ${yanghong}
 * @create 2020/3/17 10:23
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3366Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366Application.class,args);
    }
}
