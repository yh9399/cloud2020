package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 11:58
 */
@RestController
public class OrderConsumerController {
    //public static  final String PAYMENT_URL="http://localhost:8001";
    public static  final String PAYMENT_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalanced loadBalanced;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/save")
    public Response<Payment> savePayment(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/save",null,Response.class);
    }

    /**
     * 返回对象为响应体中数据转换成的对象，可以离理解为json
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/get/{id}")
    public Response<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,Response.class);
    }

    @GetMapping("consumer/payment/getForEntity/{id}")
    public Response<Payment> getForEntity(@PathVariable("id") Long id){
        ResponseEntity<Response> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,Response.class);
        if(entity.getStatusCode().is2xxSuccessful()){//2xx就表示我们的接口返回码200这一类的编码
            return  entity.getBody();
        }else {
            return  new Response<>(201,"查询失败",null);
        }
    }

    @GetMapping("consumer/payment/getPort")
    public String getPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null || instances.size()<=0){
            return  null;

        }
        ServiceInstance instance=loadBalanced.instance(instances);
        URI uri=instance.getUri();
        return  restTemplate.getForObject(uri+"/payment/getPort",String.class);
    }
}
