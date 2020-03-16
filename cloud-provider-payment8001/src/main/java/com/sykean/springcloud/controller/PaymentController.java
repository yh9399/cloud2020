package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 10:21
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/save")
    public Response save( Payment payment){
        int res=paymentService.save(payment);

        if(res>0){
            return  new Response(200,"插入数据成功",res);
        }else {
            return  new Response(555,"出入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public Response findById(@PathVariable Long id){
        Payment res=paymentService.findById(id);
        if(res!=null){
            return  new Response(200,"查询成功,端口为"+serverPort,res);
        }else {
            return  new Response(444,"查询失败",null);
        }
    }

    @GetMapping("/payment/getDiscoveryClient")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String ser : services) {
            log.info("******ser**:" + ser);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/getPort")
    public  String getPort(){
        return  serverPort;
    }

    @GetMapping("/payment/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }
}
