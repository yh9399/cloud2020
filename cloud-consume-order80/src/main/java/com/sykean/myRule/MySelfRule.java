package com.sykean.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 13:51
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //随机负载均衡策略
        return  new RandomRule();
    }
}
