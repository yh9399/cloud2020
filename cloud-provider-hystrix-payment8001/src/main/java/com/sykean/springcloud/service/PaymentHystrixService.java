package com.sykean.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author ${yanghong}
 * @create 2020/3/13 10:27
 */
@Service
public class PaymentHystrixService {
    public String ok(Integer id ){
        return "线程池："+Thread.currentThread().getName()+"\t"+id;
    }
    @HystrixCommand(fallbackMethod = "errorHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String timeOut(Integer id ){
        int number=1;
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"\t"+id;
    }
    public String errorHandle(Integer id ){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  "当前时间："+df.format(new Date());
    }

    //---服务熔断----
    @HystrixCommand(fallbackMethod = "paymentCircuitBreake_fallback" ,commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public  String paymentCircuitBreake(@PathVariable("id") Integer id){
        if(id<0){
            throw  new RuntimeException("****id 不能负数");
        }
        String uid= IdUtil.simpleUUID();
        return  Thread.currentThread().getName()+"\t"+"随机id"+uid;

    }
    public String paymentCircuitBreake_fallback(@PathVariable("id") Integer id){
        return  "id不能负数,请确认"+id;
    }

}
