package com.sykean.springcloud.contoller;

import com.sykean.springcloud.common.Response;
import com.sykean.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author ${yanghong}
 * @create 2020/3/26 14:54
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public Response decrease(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return  new Response(200,"修改账户余额成功");
    }
}
