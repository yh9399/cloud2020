package com.sykean.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 14:36
 */
@RestController
public class RateLimitController {
    /**
     * 按照资源名限流
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public Response byResource()
    {
        return new Response(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public Response handleException(BlockException exception)
    {
        return new Response(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    /**
     * 按照url地址限流
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public Response byUrl()
    {
        return new Response(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public Response customerBlockHandler()
    {
        return new Response(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }
}
