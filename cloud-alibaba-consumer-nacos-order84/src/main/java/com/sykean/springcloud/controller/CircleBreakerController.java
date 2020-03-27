package com.sykean.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 15:58
 */
@RestController
public class CircleBreakerController {
    public  static  final  String PAYMENT_URL="http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public Response<Payment> fallback(@PathVariable Long id) {
        Response<Payment> result = restTemplate.getForObject(PAYMENT_URL + "/paymentSQL/"+id, Response.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    //fallback
    public Response handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new Response<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    //blockHandler
    public Response blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new Response<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public Response<Payment> paymentSQL(@PathVariable("id") Long id){
        return  paymentService.paymentSQL(id);
    }
}
