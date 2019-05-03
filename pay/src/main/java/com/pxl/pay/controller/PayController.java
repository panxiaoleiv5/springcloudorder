package com.pxl.pay.controller;

import com.pxl.common.constants.Constants;
import com.pxl.common.dto.ResultData;
import com.pxl.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pxl
 * @description
 * @date 2019/4/14 12:17
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayService payService;

    @RequestMapping("createPayment")
    public ResultData createPayment(Long orderId){
        int flag = payService.createPay(orderId);
        if (flag == 1){
            return new ResultData(Constants.SUCCESS, "支付成功");
        } else {
            return new ResultData(Constants.ERROR, "支付失败");
        }
    }
}
