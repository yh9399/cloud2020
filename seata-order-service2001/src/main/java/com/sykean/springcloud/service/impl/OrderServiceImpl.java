package com.sykean.springcloud.service.impl;

import com.sykean.springcloud.dao.OrderDao;
import com.sykean.springcloud.entity.Order;
import com.sykean.springcloud.service.AccountService;
import com.sykean.springcloud.service.OrderService;
import com.sykean.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 11:49
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;
    @GlobalTransactional
    @Override
    public void insert(Order order) {
        log.info("新增订单开始");
        order.setId(UUID.randomUUID().toString());
        orderDao.insert(order);
        log.info("新增订单结束");

        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        log.info(order.getProductId()+"count:" + order.getCount());
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("----->订单微服务开始调用库存，做扣减end");

        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");


        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");


    }
}
