package com.sykean.springcloud.controller;

import com.sykean.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/17 15:48
 */
@RestController
public class MessageProviderController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return  messageProvider.send();
    }
}
