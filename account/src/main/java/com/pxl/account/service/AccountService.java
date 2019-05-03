package com.pxl.account.service;

import com.pxl.account.entity.Account;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 9:45
 */
public interface AccountService {
    /**
    * 通过accountId获取人员信息
    * @author pxl
    * @date 2019/4/12 9:46
    * @param accountId
    * @return com.pxl.account.entity.AccountEntity
    **/
    Account getAccountById(Long accountId);

    int updateAccount(Account account);
}
