package com.sykean.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ${yanghong}
 * @create 2020/3/16 13:56
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator custemRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder=routeLocatorBuilder.routes();
        //定义一个名为path_route_sykean的路由，当我们访问localhost:9527/guoji的时候会帮我们路由到http://news.baidu.com/guoji
        builder.route("path_route_sykean",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        builder.route("path_route_sykean2",
                r->r.path("/mil")
                        .uri("http://news.baidu.com/mil")).build();
        return  builder.build();
    }
}
