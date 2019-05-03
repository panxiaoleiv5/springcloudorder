package com.pxl.order.controller;

import com.pxl.common.constants.Constants;
import com.pxl.common.dto.ResultData;
import com.pxl.order.entity.OrderInfo;
import com.pxl.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 17:06
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public void createOrder(Long accountId, Long commodityId, Integer commodityCount){
        orderService.createOrder(accountId, commodityId, commodityCount);
    }

    @RequestMapping("/getOrderById")
    public ResultData getOrderById(Long orderId){
        OrderInfo orderInfo = orderService.getOrderById(orderId);
        return new ResultData(Constants.SUCCESS, "获取订单成功", orderInfo);
    }

    @RequestMapping("/updateOrder")
    public ResultData updatePaymentStatusOfOrder(Long orderId){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(orderId);
        orderInfo.setPayStatus(1);
        int flag = orderService.updatePaymentStatusOfOrder(orderInfo);
        if (flag == 1){
            return new ResultData(Constants.SUCCESS, "更新支付状态成功");
        } else {
            return new ResultData(Constants.ERROR, "更新支付状态失败");
        }
    }
}
