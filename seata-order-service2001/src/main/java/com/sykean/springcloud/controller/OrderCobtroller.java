package com.sykean.springcloud.controller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.entity.Order;
import com.sykean.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 13:52
 */
@RestController
public class OrderCobtroller {
    @Autowired
    private OrderService orderService;

    @GetMapping("/saveOrder")
    public Response saveOrder(Order order){
        orderService.insert(order);
        return  new Response(200,"新建订单成功");
    }
}
