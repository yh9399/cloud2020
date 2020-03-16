package com.sykean.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author ${yanghong}
 * @create 2020/3/16 15:22
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 判断每次请求是否带有参数uname,如果uname为空则为非法用户，不为空则放行进行下一次过滤
     * @param exchange
     * @param chain
     * @return
     */
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********this is myGlobalFilter**********"+new Date());
        String uname=exchange.getRequest().getQueryParams().getFirst("uname"); //获取第一个参数
        if(StringUtils.isEmpty(uname)){
            log.info("用户名为空，非法用户，/(ㄒoㄒ)/~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
