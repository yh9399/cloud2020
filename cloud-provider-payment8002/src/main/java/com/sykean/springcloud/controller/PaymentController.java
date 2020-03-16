package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Payment;
import com.sykean.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 10:21
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/save")
    public Response save( Payment payment){
        int res=paymentService.save(payment);
        log.info("*****插入结果 "+res);

        if(res>0){
            return  new Response(200,"插入数据成功",res);
        }else {
            return  new Response(555,"出入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public Response findById(@PathVariable Long id){
        Payment res=paymentService.findById(id);
        log.info("*****+++++++++");
        if(res!=null){
            return  new Response(200,"查询成功,端口为"+serverPort,res);
        }else {
            return  new Response(444,"查询失败",null);
        }
    }
    @GetMapping("/payment/getPort")
    public  String getPort(){
        return  serverPort;
    }
}
