package com.sykean.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sykean.springcloud.common.Response;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 14:58
 */
public class CustomerBlockHandler {
        public static Response handleException1(BlockException exception){
            return  new Response(4444,"自定义限流处理信心----------1");
        }
    public static Response handleException2(BlockException exception){
        return  new Response(4444,"自定义限流处理信心----------2");
    }
}
