package com.sykean.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.NestingKind;
import java.util.UUID;

/**
 * @Author ${yanghong}
 * @create 2020/3/12 9:48
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/getConsul")
    public String getConsul(){
        return  "this is springcloud for consul"+"\t"+serverPort+"/t"+ UUID.randomUUID().toString();
    }
}
