package com.sykean.springcloud.service.impl;

import com.sykean.springcloud.dao.AccountDao;
import com.sykean.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:50
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    public void decrease(String userId, BigDecimal money) {

        accountDao.decrease(userId,money);
    }
}
