package com.sykean.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 13:41
 */
@Configuration
@MapperScan({"com.sykean.springcloud.dao"})
public class MyBatisConfig {
}
