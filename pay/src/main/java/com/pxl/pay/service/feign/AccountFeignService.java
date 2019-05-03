package com.pxl.pay.service.feign;

import com.pxl.common.dto.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author pxl
 * @description
 * @date 2019/4/14 13:55
 */
@FeignClient(name = "${feign.remote.account-service}", path = "/account")
public interface AccountFeignService {
    @RequestMapping("/getAccountById")
    ResultData getAccountById(@RequestParam("accountId") Long accountId);

    @RequestMapping("/updateAccount")
    ResultData updateAccount(@RequestParam("accountId") Long accountId, @RequestParam(value = "userName" ,required = false) String userName, @RequestParam("balance") BigDecimal balance);
}
