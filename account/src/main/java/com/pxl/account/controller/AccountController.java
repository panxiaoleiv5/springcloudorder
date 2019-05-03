package com.pxl.account.controller;

import com.pxl.account.entity.Account;
import com.pxl.common.constants.Constants;
import com.pxl.common.dto.ResultData;
import com.pxl.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 9:40
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/getAccountById")
    public ResultData getAccountById(Long accountId){
        Account accountEntity = accountService.getAccountById(accountId);
        int i = 1/0;
        return new ResultData(Constants.SUCCESS,"获取人员成功",accountEntity);
    }

    @RequestMapping("/updateAccount")
    ResultData updateAccount(Long accountId, String userName, BigDecimal balance){
        Account account = new Account();
        account.setAccountId(accountId);
        account.setAccountName(userName);
        account.setBalance(balance);
        account.setUpdateTime(new Date());
        int flag = accountService.updateAccount(account);
        if (flag == 1){
            return new ResultData(Constants.SUCCESS, "更新人员信息成功");
        } else {
            return new ResultData(Constants.ERROR, "更新人员信息失败");
        }

    }
}
