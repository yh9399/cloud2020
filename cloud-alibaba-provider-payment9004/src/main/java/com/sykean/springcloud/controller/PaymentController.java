package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author ${yanghong}
 * @create 2020/3/24 15:47
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static{
        hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }
    @GetMapping(value = "/paymentSQL/{id}")
    public Response<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        Response<Payment> result = new Response(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }
}
