package com.pxl.pay.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pxl.common.dto.ResultData;
import com.pxl.pay.dao.PayMapper;
import com.pxl.pay.entity.Account;
import com.pxl.pay.entity.Commodity;
import com.pxl.pay.entity.OrderInfo;
import com.pxl.pay.entity.Pay;
import com.pxl.pay.service.PayService;
import com.pxl.pay.service.feign.AccountFeignService;
import com.pxl.pay.service.feign.CommodityFeignService;
import com.pxl.pay.service.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author pxl
 * @description
 * @date 2019/4/14 12:18
 */
@Service("payService")
public class PayServiceImpl implements PayService {
    @Autowired
    private PayMapper payMapper;
    @Autowired
    private CommodityFeignService commodityFeignService;
    @Autowired
    private OrderFeignService orderFeignService;
    @Autowired
    private AccountFeignService accountFeignService;

    @Override
    @GlobalTransactional
    public int createPay(Long orderId) {
        ResultData resultData = orderFeignService.getOrderById(orderId);
        Map map = (Map) resultData.getData();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str = gson.toJson(map);
        OrderInfo orderInfo = gson.fromJson(str, OrderInfo.class);

        resultData = commodityFeignService.getCommodityById(orderInfo.getCommodityId());
        map = (Map) resultData.getData();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        str = gson.toJson(map);
        Commodity commodity = gson.fromJson(str, Commodity.class);

        resultData = accountFeignService.getAccountById(orderInfo.getAccountId());
        map = (Map) resultData.getData();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        str = gson.toJson(map);
        Account account = gson.fromJson(str, Account.class);

        Integer num = orderInfo.getCommodityCount();
        BigDecimal price = commodity.getCommodityPrice();
        BigDecimal paymentAmount = price.multiply(new BigDecimal(num));
        if (account.getBalance().compareTo(paymentAmount) == -1){
            throw new RuntimeException("账户余额不足");
        }

        accountFeignService.updateAccount(orderInfo.getAccountId(), null, account.getBalance().subtract(paymentAmount));

        orderFeignService.updatePaymentStatusOfOrder(orderId);

        Pay pay = new Pay();
        pay.setPaymentAmount(paymentAmount);
        pay.setOrderId(orderId);
        pay.setCreateTime(new Date());
        return payMapper.insert(pay);
    }
}
