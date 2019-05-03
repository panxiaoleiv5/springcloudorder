package com.pxl.account.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.pxl.account.dao.AccountMapper;
import com.pxl.account.entity.Account;
import com.pxl.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 9:45
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAccountById(Long accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    @Override
    @Transactional
    public int updateAccount(Account account) {
        return accountMapper.updateByPrimaryKeySelective(account);
    }
}
