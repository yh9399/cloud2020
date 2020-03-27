package com.sykean.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/23 10:50
 */
@RestController

@Slf4j
public class TestController {
    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName()+"\t"+"test A");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }
    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("RT testD");
        return "------testD";
    }
    @GetMapping("/testE")
    public String testE() {

        log.info("异常数，test e");
        int age=10/0;
        return "------异常数。test e";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "fall_back_hot")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2) {
        return "------testHotKey";
    }

    public  String fall_back_hot(String p1, String p2, BlockException b){
        return  "fall_back_hot";
    }
}
